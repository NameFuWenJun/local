package PoiTest.main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import PoiTest.pojo.Book;
import PoiTest.pojo.Student;

/**
 * 使用poi导出excel;使用泛型代表任意Javabean均可以导出
 * @author fuwenjun01
 *应用泛型，代表任意一个符合javabean风格的类 
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx() 
 *            byte[]表jpg格式的图片数据 
 */
 

public class ExportExcelUtils<T> {
	public void exportExcel(Collection<T> dataset,OutputStream out){
		exportExcel("测试poi导出Excel文档",null,dataset,out ,"yyyy-MM-dd");

	}
	public void exportExcel(String[] headers, Collection<T> dataset,  
			OutputStream out, String pattern)  
	{  
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, pattern);  
	}  
	public void exportExcel(String[] headers, Collection<T> dataset,  
			OutputStream out)  
	{  
		exportExcel("测试POI导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");  
	}  


	//导出xlsx的excel文件格式,该方法中不包含对单元格格式的设置
	@SuppressWarnings({ "resource", "unchecked" })
	public void exportXlsx(String title, String[] headers,  
			Collection<T> dataset,String pathName, String pattern){
		// 声明一个工作薄
		XSSFWorkbook workBook= new XSSFWorkbook();
		// 生成一个表格
		XSSFSheet sheet = workBook.createSheet();
		workBook.setSheetName(0,title);
		//设置表格默认宽度
		sheet.setDefaultColumnWidth(15);
		//生成一个样式
		//样式设置省略  

		//声明一个画图的顶级管理器
		XSSFDrawing drawing=sheet.createDrawingPatriarch();
		//添加注释,XSSFAnchor,为 添加注释的位置信息
		XSSFComment comment=drawing.createCellComment(new XSSFClientAnchor(0,  
				0, 0, 0, (short) 4, 2, (short) 6, 5)); 
		comment.setString(new XSSFRichTextString("可以添加注释"));
		comment.setAuthor("test");
		// 创建表格标题行 第一行
		XSSFRow row = sheet.createRow(0);
		for(short i=0;i<headers.length;i++){
			XSSFCell cell=row.createCell(i);
			XSSFRichTextString text=new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		//遍历集合数据,产生数据行
		Iterator<T> it=dataset.iterator();
		int index=0;
		while(it.hasNext()){
			index++;
			row=sheet.createRow(index);
			T t=it.next();
			//利用反射,根据Javabean属性的先后顺序,动态调用get方法
			Field [] fields=t.getClass().getDeclaredFields();
			for(short i=0;i<fields.length;i++){
				XSSFCell cell =row.createCell(i);
				Field field=fields[i];
				String fieldName=field.getName();
				String getMethodName= "get"  
						+ fieldName.substring(0, 1).toUpperCase()  
						+ fieldName.substring(1); 
				try  
				{  
					Class tCls = t.getClass();  
					Method getMethod = tCls.getMethod(getMethodName,  
							new Class[]  
									{});  
					Object value = getMethod.invoke(t, new Object[]  
							{});  
					// 判断值的类型后进行强制类型转换  
					String textValue = null;  
					if (value instanceof Boolean)  
					{  
						boolean bValue = (Boolean) value;  
						textValue = "男";  
						if (!bValue)  
						{  
							textValue = "女";  
						}  
					}  
					else if (value instanceof Date)  
					{  
						Date date = (Date) value;  
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
						textValue = sdf.format(date);  
					}  
					else if (value instanceof byte[])  
					{  
						// 有图片时，设置行高为60px;  
						row.setHeightInPoints(60);  
						// 设置图片所在列宽度为80px,注意这里单位的一个换算  
						sheet.setColumnWidth(i, (short) (35.7 * 80));  
						// sheet.autoSizeColumn(i);  
						byte[] bsValue = (byte[]) value;  
						// XSSFClientAnchor的参数说明： 
						// 参数 说明 
						// dx1 第1个单元格中x轴的偏移量 
						// dy1 第1个单元格中y轴的偏移量 
						// dx2 第2个单元格中x轴的偏移量 
						// dy2 第2个单元格中y轴的偏移量 
						// col1 第1个单元格的列号 
						// row1 第1个单元格的行号 
						// col2 第2个单元格的列号 
						// row2 第2个单元格的行号 
						XSSFClientAnchor anchor = new XSSFClientAnchor(1, 1,  
								1, 1, (short) 6, index, (short) 6, index);  
						//anchor.setAnchorType(2);  
						//int pictureIdx =input_work.addPicture(in, input_work.PICTURE_TYPE_JPEG);//向excel中插入图片 
						XSSFPicture pict = drawing.createPicture(anchor, workBook.addPicture(  
								bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));  
						pict.resize(1,1);
						//pict.resize();   //该方法不改变图片大小
					}  
					else  
					{  
						// 其它数据类型都当作字符串简单处理  
						textValue = value.toString();  
					}  
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成  
					if (textValue != null)  
					{  
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
						Matcher matcher = p.matcher(textValue);  
						if (matcher.matches())  
						{  
							// 是数字当作double处理  
							cell.setCellValue(Double.parseDouble(textValue));  
						}  
						else  
						{  
							XSSFRichTextString richString = new XSSFRichTextString(  
									textValue);  
							cell.setCellValue(richString);  
						}  
					}  
				}  
				catch (SecurityException e)  
				{  
					e.printStackTrace();  
				}  
				catch (NoSuchMethodException e)  
				{  
					e.printStackTrace();  
				}  
				catch (IllegalArgumentException e)  
				{  
					e.printStackTrace();  
				}  
				catch (IllegalAccessException e)  
				{  
					e.printStackTrace();  
				}  
				catch (InvocationTargetException e)  
				{  
					e.printStackTrace();  
				}  


			}

			try  
			{  
				OutputStream out=new FileOutputStream(pathName);
				workBook.write(out);  
				out.close();
			}  
			catch (IOException e)  
			{  
				e.printStackTrace();  
			}


			/*  for(int i=0;i<cellTitle.length;i++){
	        titleRow.createCell(i).setCellValue(cellTitle[i]);
	    }
	    //插入需导出的数据
	    for(int i=0;i<dataList.size();i++){
	        XSSFRow row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(dataList.get(i)[0]);
	        row.createCell(2).setCellValue(dataList.get(i)[1]);
	        row.createCell(3).setCellValue(dataList.get(i)[2]);
	        row.createCell(4).setCellValue(dataList.get(i)[3]);
	    }
	    File  file = new File(basePath+exportFileName);*/

			/*  try {
	    	   //文件输出流
		    FileOutputStream outStream = new FileOutputStream(file);
		    workBook.write(outStream);
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

			// System.out.println("导出2007文件成功！文件导出路径：--"+basePath+exportFileName);

		}
	}
	/**
	 * 
	 * @param title  sheet名
	 * @param headers 表格属性列名数值
	 * @param dataset 显示的数据集合,集合中保存符合javabean风格的类的对象,该方法支持的javabean属性的数据类型有基本数据类型及string,Date,byte[] (图片数据)
	 * @param out  与输出设备关联的流对象,将excel文档导出到本地文件或者网络中
	 * @param pattern   如果有时间数据,设定输出格式,默认为"yyyy-MM-dd"
	 * @param type  type=0输出xls文档,type=1:输出xlsx文档
	 */
	@SuppressWarnings({ "resource", "deprecation" })
	public void exportExcel(String title,String [] headers,Collection<T> dataset,OutputStream out ,String pattern){
		//声明一个工作薄
		HSSFWorkbook workbook=new HSSFWorkbook();
		//生成一个表格
		HSSFSheet sheet=workbook.createSheet(title);
		//设置表格的默认列宽度为15
		sheet.setDefaultColumnWidth((short)15);
		//生成一个样式
		HSSFCellStyle style= workbook.createCellStyle();
		//设置单元格样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//生成一个字体
		HSSFFont font=workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);  
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
		//把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式  
		HSSFCellStyle style2 = workbook.createCellStyle();  
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
		// 生成另一个字体  
		HSSFFont font2 = workbook.createFont();  
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
		// 把字体应用到当前的样式  
		style2.setFont(font2);  

		//声明一个画图的顶级管理器
		HSSFPatriarch patriarch=sheet.createDrawingPatriarch();
		//定义注释的大小和位置,详细查文档
		HSSFComment comment=patriarch.createComment(new HSSFClientAnchor(0,0,0,0,(short)4,2,(short)6,(short)5));
		//设置注释内容
		comment.setString(new HSSFRichTextString("poi中的注释"));
		//设置注释作者,当鼠标移动到单元格上是可以在状态栏看到该内容
		comment.setAuthor("fuwenjun");
		//产生表格标题行
		HSSFRow row=sheet.createRow(0);
		for(int i=0;i<headers.length;i++){
			HSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text=new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		//遍历集合数据,产生数据行
		Iterator <T> it=dataset.iterator();
		int index=0;
		while(it.hasNext()){
			index++;
			row = sheet.createRow(index);
			T t=(T) it.next();
			//利用反射,根据javabean属性的先后顺序,动态调用getXX方法得到属性
			Field [] fields=t.getClass().getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				HSSFCell cell=row.createCell(i);
				cell.setCellStyle(style2);
				Field field=fields[i];
				String fieldName=field.getName();
				String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

				try {
					@SuppressWarnings("rawtypes")
					Class tCls=t.getClass();
					@SuppressWarnings("unchecked")
					Method getMethod=tCls.getMethod(getMethodName, new Class[] {});
					Object value=getMethod.invoke(t, new Object[]{});
					String textValue=null;
					if (value instanceof Boolean)  
					{  
						boolean bValue = (Boolean) value;  
						textValue = "男";  
						if (!bValue)  
						{  
							textValue = "女";  
						}  
					}  
					else if (value instanceof Date)  
					{  
						Date date = (Date) value;  
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
						textValue = sdf.format(date);  
					}  
					else if (value instanceof byte[])  
					{  
						// 有图片时，设置行高为60px;  
						row.setHeightInPoints(60);  
						// 设置图片所在列宽度为80px,注意这里单位的一个换算  
						sheet.setColumnWidth(i, (short) (35.7 * 80));  
						// sheet.autoSizeColumn(i);  
						byte[] bsValue = (byte[]) value;  
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,  
								1023, 255, (short) 6, index, (short) 6, index);  
						anchor.setAnchorType(2);  
						patriarch.createPicture(anchor, workbook.addPicture(  
								bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));  
					}  
					else  
					{  
						// 其它数据类型都当作字符串简单处理  
						textValue = value.toString();  
					}  
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成  
					if (textValue != null)  
					{  
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
						Matcher matcher = p.matcher(textValue);  
						if (matcher.matches())  
						{  
							// 是数字当作double处理  
							cell.setCellValue(Double.parseDouble(textValue));  
						}  
						else  
						{  
							HSSFRichTextString richString = new HSSFRichTextString(  
									textValue);  
							HSSFFont font3 = workbook.createFont();  
							font3.setColor(HSSFColor.BLUE.index);  
							richString.applyFont(font3);  
							cell.setCellValue(richString);  
						}  
					}  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					//释放资源
				}
			}
		}
		try{
			workbook.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ExportExcelUtils<Student> ex=new ExportExcelUtils<Student>();
		String [] headers={"学号","姓名","年龄","性别","出生日期"};
		List <Student> dataset=new ArrayList<Student>();
		dataset.add(new Student(123213,"章程",21,true,new Date()));
		dataset.add(new Student(2341241,"大卫",22,false,new Date()));
		//测试另一个javabean
		ExportExcelUtils<Book> ex2=new ExportExcelUtils<Book>();
		String [] headers2={"图书编号","图书名称","图书作者","图书价格","图书ISBN","图书出版社","封面图片"};
		List<Book> dataset2=new ArrayList<Book>();
		try  
		{  
			BufferedInputStream bis = new BufferedInputStream(  
					new FileInputStream("E://book.bmp"));  
			byte[] buf = new byte[bis.available()];  
			while ((bis.read(buf)) != -1)  
			{  
				//  
			}  
			dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",  
					"清华出版社", buf));  
			dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567",  
					"阳光出版社", buf));  
			dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567",  
					"清华出版社", buf));  
			dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567",  
					"清华出版社", buf));  
			dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567",  
					"汤春秀出版社", buf));  

			OutputStream out = new FileOutputStream("E://a.xls");  
			OutputStream out2 = new FileOutputStream("E://b.xlsx");  
			ex.exportExcel(headers, dataset, out);  
			//ex2.exportXlsx("测试POI导出EXCEL文档", headers, dataset, out,"yyyy-MM-dd");
			ex2.exportXlsx("测试xlsx", headers2, dataset2, "E://b.xlsx", "yyyy-MM-dd");
			out.close();  
			out2.close();  
			//ex2.exportXlsx();
			JOptionPane.showMessageDialog(null, "导出成功!");  
			System.out.println("excel导出成功！");  
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

	}	
}
