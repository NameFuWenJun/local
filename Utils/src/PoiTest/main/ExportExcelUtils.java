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
 * ʹ��poi����excel;ʹ�÷��ʹ�������Javabean�����Ե���
 * @author fuwenjun01
 *Ӧ�÷��ͣ���������һ������javabean������ 
 *            ע������Ϊ�˼������boolean�͵�����xxx��get����ʽΪgetXxx(),������isXxx() 
 *            byte[]��jpg��ʽ��ͼƬ���� 
 */
 

public class ExportExcelUtils<T> {
	public void exportExcel(Collection<T> dataset,OutputStream out){
		exportExcel("����poi����Excel�ĵ�",null,dataset,out ,"yyyy-MM-dd");

	}
	public void exportExcel(String[] headers, Collection<T> dataset,  
			OutputStream out, String pattern)  
	{  
		exportExcel("����POI����EXCEL�ĵ�", headers, dataset, out, pattern);  
	}  
	public void exportExcel(String[] headers, Collection<T> dataset,  
			OutputStream out)  
	{  
		exportExcel("����POI����EXCEL�ĵ�", headers, dataset, out, "yyyy-MM-dd");  
	}  


	//����xlsx��excel�ļ���ʽ,�÷����в������Ե�Ԫ���ʽ������
	@SuppressWarnings({ "resource", "unchecked" })
	public void exportXlsx(String title, String[] headers,  
			Collection<T> dataset,String pathName, String pattern){
		// ����һ��������
		XSSFWorkbook workBook= new XSSFWorkbook();
		// ����һ�����
		XSSFSheet sheet = workBook.createSheet();
		workBook.setSheetName(0,title);
		//���ñ��Ĭ�Ͽ��
		sheet.setDefaultColumnWidth(15);
		//����һ����ʽ
		//��ʽ����ʡ��  

		//����һ����ͼ�Ķ���������
		XSSFDrawing drawing=sheet.createDrawingPatriarch();
		//���ע��,XSSFAnchor,Ϊ ���ע�͵�λ����Ϣ
		XSSFComment comment=drawing.createCellComment(new XSSFClientAnchor(0,  
				0, 0, 0, (short) 4, 2, (short) 6, 5)); 
		comment.setString(new XSSFRichTextString("�������ע��"));
		comment.setAuthor("test");
		// ������������ ��һ��
		XSSFRow row = sheet.createRow(0);
		for(short i=0;i<headers.length;i++){
			XSSFCell cell=row.createCell(i);
			XSSFRichTextString text=new XSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		//������������,����������
		Iterator<T> it=dataset.iterator();
		int index=0;
		while(it.hasNext()){
			index++;
			row=sheet.createRow(index);
			T t=it.next();
			//���÷���,����Javabean���Ե��Ⱥ�˳��,��̬����get����
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
					// �ж�ֵ�����ͺ����ǿ������ת��  
					String textValue = null;  
					if (value instanceof Boolean)  
					{  
						boolean bValue = (Boolean) value;  
						textValue = "��";  
						if (!bValue)  
						{  
							textValue = "Ů";  
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
						// ��ͼƬʱ�������и�Ϊ60px;  
						row.setHeightInPoints(60);  
						// ����ͼƬ�����п��Ϊ80px,ע�����ﵥλ��һ������  
						sheet.setColumnWidth(i, (short) (35.7 * 80));  
						// sheet.autoSizeColumn(i);  
						byte[] bsValue = (byte[]) value;  
						// XSSFClientAnchor�Ĳ���˵���� 
						// ���� ˵�� 
						// dx1 ��1����Ԫ����x���ƫ���� 
						// dy1 ��1����Ԫ����y���ƫ���� 
						// dx2 ��2����Ԫ����x���ƫ���� 
						// dy2 ��2����Ԫ����y���ƫ���� 
						// col1 ��1����Ԫ����к� 
						// row1 ��1����Ԫ����к� 
						// col2 ��2����Ԫ����к� 
						// row2 ��2����Ԫ����к� 
						XSSFClientAnchor anchor = new XSSFClientAnchor(1, 1,  
								1, 1, (short) 6, index, (short) 6, index);  
						//anchor.setAnchorType(2);  
						//int pictureIdx =input_work.addPicture(in, input_work.PICTURE_TYPE_JPEG);//��excel�в���ͼƬ 
						XSSFPicture pict = drawing.createPicture(anchor, workBook.addPicture(  
								bsValue, XSSFWorkbook.PICTURE_TYPE_JPEG));  
						pict.resize(1,1);
						//pict.resize();   //�÷������ı�ͼƬ��С
					}  
					else  
					{  
						// �����������Ͷ������ַ����򵥴���  
						textValue = value.toString();  
					}  
					// �������ͼƬ���ݣ�������������ʽ�ж�textValue�Ƿ�ȫ�����������  
					if (textValue != null)  
					{  
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
						Matcher matcher = p.matcher(textValue);  
						if (matcher.matches())  
						{  
							// �����ֵ���double����  
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
	    //�����赼��������
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
	    	   //�ļ������
		    FileOutputStream outStream = new FileOutputStream(file);
		    workBook.write(outStream);
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

			// System.out.println("����2007�ļ��ɹ����ļ�����·����--"+basePath+exportFileName);

		}
	}
	/**
	 * 
	 * @param title  sheet��
	 * @param headers �������������ֵ
	 * @param dataset ��ʾ�����ݼ���,�����б������javabean������Ķ���,�÷���֧�ֵ�javabean���Ե����������л����������ͼ�string,Date,byte[] (ͼƬ����)
	 * @param out  ������豸������������,��excel�ĵ������������ļ�����������
	 * @param pattern   �����ʱ������,�趨�����ʽ,Ĭ��Ϊ"yyyy-MM-dd"
	 * @param type  type=0���xls�ĵ�,type=1:���xlsx�ĵ�
	 */
	@SuppressWarnings({ "resource", "deprecation" })
	public void exportExcel(String title,String [] headers,Collection<T> dataset,OutputStream out ,String pattern){
		//����һ��������
		HSSFWorkbook workbook=new HSSFWorkbook();
		//����һ�����
		HSSFSheet sheet=workbook.createSheet(title);
		//���ñ���Ĭ���п��Ϊ15
		sheet.setDefaultColumnWidth((short)15);
		//����һ����ʽ
		HSSFCellStyle style= workbook.createCellStyle();
		//���õ�Ԫ����ʽ
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//����һ������
		HSSFFont font=workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);  
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 
		//������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
		// ���ɲ�������һ����ʽ  
		HSSFCellStyle style2 = workbook.createCellStyle();  
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
		// ������һ������  
		HSSFFont font2 = workbook.createFont();  
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
		// ������Ӧ�õ���ǰ����ʽ  
		style2.setFont(font2);  

		//����һ����ͼ�Ķ���������
		HSSFPatriarch patriarch=sheet.createDrawingPatriarch();
		//����ע�͵Ĵ�С��λ��,��ϸ���ĵ�
		HSSFComment comment=patriarch.createComment(new HSSFClientAnchor(0,0,0,0,(short)4,2,(short)6,(short)5));
		//����ע������
		comment.setString(new HSSFRichTextString("poi�е�ע��"));
		//����ע������,������ƶ�����Ԫ�����ǿ�����״̬������������
		comment.setAuthor("fuwenjun");
		//������������
		HSSFRow row=sheet.createRow(0);
		for(int i=0;i<headers.length;i++){
			HSSFCell cell=row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text=new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		//������������,����������
		Iterator <T> it=dataset.iterator();
		int index=0;
		while(it.hasNext()){
			index++;
			row = sheet.createRow(index);
			T t=(T) it.next();
			//���÷���,����javabean���Ե��Ⱥ�˳��,��̬����getXX�����õ�����
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
						textValue = "��";  
						if (!bValue)  
						{  
							textValue = "Ů";  
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
						// ��ͼƬʱ�������и�Ϊ60px;  
						row.setHeightInPoints(60);  
						// ����ͼƬ�����п��Ϊ80px,ע�����ﵥλ��һ������  
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
						// �����������Ͷ������ַ����򵥴���  
						textValue = value.toString();  
					}  
					// �������ͼƬ���ݣ�������������ʽ�ж�textValue�Ƿ�ȫ�����������  
					if (textValue != null)  
					{  
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");  
						Matcher matcher = p.matcher(textValue);  
						if (matcher.matches())  
						{  
							// �����ֵ���double����  
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
					//�ͷ���Դ
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
		String [] headers={"ѧ��","����","����","�Ա�","��������"};
		List <Student> dataset=new ArrayList<Student>();
		dataset.add(new Student(123213,"�³�",21,true,new Date()));
		dataset.add(new Student(2341241,"����",22,false,new Date()));
		//������һ��javabean
		ExportExcelUtils<Book> ex2=new ExportExcelUtils<Book>();
		String [] headers2={"ͼ����","ͼ������","ͼ������","ͼ��۸�","ͼ��ISBN","ͼ�������","����ͼƬ"};
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
					"�廪������", buf));  
			dataset2.add(new Book(2, "java���˼��", "brucl", 300.33f, "1234567",  
					"���������", buf));  
			dataset2.add(new Book(3, "DOM����", "lenotang", 300.33f, "1234567",  
					"�廪������", buf));  
			dataset2.add(new Book(4, "c++����", "leno", 400.33f, "1234567",  
					"�廪������", buf));  
			dataset2.add(new Book(5, "c#����", "leno", 300.33f, "1234567",  
					"�����������", buf));  

			OutputStream out = new FileOutputStream("E://a.xls");  
			OutputStream out2 = new FileOutputStream("E://b.xlsx");  
			ex.exportExcel(headers, dataset, out);  
			//ex2.exportXlsx("����POI����EXCEL�ĵ�", headers, dataset, out,"yyyy-MM-dd");
			ex2.exportXlsx("����xlsx", headers2, dataset2, "E://b.xlsx", "yyyy-MM-dd");
			out.close();  
			out2.close();  
			//ex2.exportXlsx();
			JOptionPane.showMessageDialog(null, "�����ɹ�!");  
			System.out.println("excel�����ɹ���");  
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

	}	
}
