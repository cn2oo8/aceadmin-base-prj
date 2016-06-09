package com.shareyi.jshow.filetest;

import com.shareyi.jshow.file.DiskFileInputOutputService;
import com.shareyi.jshow.file.FileInputOutputService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 *
 * 文件读写测试类（磁盘文件读写）
 * All test passed
 * Created by david on 2015/10/22.
 */
public class DiskFileIOTest {


    private FileInputOutputService fileInputOutputService;
    private FileBean fileBean;
    private FileBeanExt fileBeanExt;

    @Before
    public void before(){
        if(fileInputOutputService==null){
            DiskFileInputOutputService fileInputOutputService=new DiskFileInputOutputService();
            fileInputOutputService.setBasePath("F:/cmsfile");
            this.fileInputOutputService=fileInputOutputService;
        }
        fileBean=new FileBean();
        fileBean.setCssContent("css content");
        fileBean.setHtmlContent("html content");

        fileBeanExt=new FileBeanExt();
        fileBeanExt.setCssContent("css content 中文");
        fileBeanExt.setHtmlContent("html content 中文");

    }


    /**
     * 测试直接写入字符串
     * @throws IOException
     */
    @Test
    public void testWriteStringToFile() throws IOException {
        boolean isSucess=fileInputOutputService.write("testfile","prototype","i love youxxxxxxxxxxx!");
        Assert.assertTrue(isSucess);
    }

    /**
     * 测试直接读取字符串
     * @throws IOException
     */
    @Test
    public void testReadPojoFromFile() throws IOException {
        String fileContent=fileInputOutputService.read("testfile", "prototype", String.class);
        Assert.assertNotNull(fileContent);
    }


    /**
     * 测试写入文件内容
     * @throws IOException
     */
    @Test
    public void testWritePojoToFile() throws IOException {
        boolean isSucess=fileInputOutputService.write("testfilebean", "prototype", fileBean);
        Assert.assertTrue(isSucess);
    }


    /**
     * 测试从文件中读取内容
     * @throws IOException
     */
    @Test
    public void testReadStringFromFile() throws IOException {
        FileBean fileBean=fileInputOutputService.read("testfilebean", "prototype", FileBean.class);
        Assert.assertNotNull(fileBean);
        Assert.assertNotNull(fileBean.getCssContent());
        Assert.assertNotNull(fileBean.getHtmlContent());
        System.out.println(fileBean.getCssContent());
        System.out.println(fileBean.getHtmlContent());
    }



    /**
     * 测试从文件中读取内容
     * @throws IOException
     */
    @Test
    public void testWriteObject2File() throws IOException {

        boolean isSucess=fileInputOutputService.write("parentDir", "fileWithExt", fileBeanExt);
        Assert.assertTrue(isSucess);


        FileBeanExt fileBean=fileInputOutputService.read("parentDir", "fileWithExt", FileBeanExt.class);
        Assert.assertNotNull(fileBean);
        Assert.assertNotNull(fileBean.getCssContent());
        Assert.assertNotNull(fileBean.getHtmlContent());
        System.out.println(fileBean.getCssContent());
        System.out.println(fileBean.getHtmlContent());



        //尝试将内容改为空
        fileBeanExt.setCssContent(null);
        fileInputOutputService.write("parentDir", "fileWithExt", fileBeanExt);

        fileBean=fileInputOutputService.read("parentDir", "fileWithExt", FileBeanExt.class);
        Assert.assertNull(fileBean.getCssContent());
    }




    /**
     * 测试直接写入字符串
     * @throws IOException
     */
    @Test
    public void testWriteByteArray() throws IOException {
        byte[] bytes="i love youxxxxxxxxxxx!".getBytes("UTF-8");
        boolean isSucess=fileInputOutputService.write("testByteFile.txt","prototype",bytes);
        byte[] fileContent=fileInputOutputService.read("testByteFile.txt", "prototype", bytes.getClass());

        Assert.assertEquals(bytes.length, fileContent.length);
    }


    @Test
    public void testDeleteFile() throws IOException {
        boolean isSucess=fileInputOutputService.deleteFile("testfile", "prototype");
        System.out.println(isSucess);

    }


    @Test
    public void testFileExist() throws IOException {
        boolean exist=fileInputOutputService.fileExist("testfilebean", "prototype");
        System.out.println(exist);
    }


}
