package com.huang.server.utils;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * FastDFS工具类
 */
@Slf4j
public class FastDFSUtils {

    /**
     * 初始化客户端
     * ClientGlobal.init 读取配置文件，并初始化对应的属性
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            log.error("初始化FastDFS失败",e.getMessage());
        }
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    public static String[] upload(MultipartFile file){
        String name = file.getOriginalFilename();
        log.info("文件名:",name);
        StorageClient storageClient = null;
        String[] uploadResults = null;
        try {
            //获取storage客户端
            storageClient = getStorageClient();
            //上传
            uploadResults = storageClient.upload_file(file.getBytes(), name.substring(name.indexOf(".") + 1), null);
        } catch (Exception e) {
            log.error("上传文件失败",e.getMessage());
        }
        if(null==uploadResults){
            log.error("上传失败",storageClient.getErrorCode());
        }
        return uploadResults;
    }

    /**
     * 获取文件信息
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static FileInfo getFileInfo(String groupName, String remoteFileName){
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            return storageClient.get_file_info(groupName,remoteFileName);
        } catch (Exception e) {
            log.info("文件信息获取失败",e.getMessage());
        }
        return null;
    }

    /**
     * 下载文件
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName,String remoteFileName){
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream inputStream = new ByteArrayInputStream(fileByte);
            return inputStream;
        } catch (Exception e) {
            log.info("文件下载失败失败",e.getMessage());
        }
        return null;
    }

    /**
     * 删除文件
     * @param groupName
     * @param remoteFileName
     */
    public static void deleteFile(String groupName,String remoteFileName){
        StorageClient storageClient = null;
        try {
            storageClient = getStorageClient();
            storageClient.delete_file(groupName,remoteFileName);
        } catch (Exception e) {
            log.info("文件删除失败",e.getMessage());
        }
    }


    /**
     * 生成storage客户端
     * @return
     * @throws IOException
     */
    private static StorageClient getStorageClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        return storageClient;
    }

    /**
     * 生成tracker服务器
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        return trackerServer;
    }

    /**
     * 获取文件路径
     * @return
     */
    public static String getTrackerUrl(){
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        try {
             trackerServer = trackerClient.getTrackerServer();
             storageServer = trackerClient.getStoreStorage(trackerServer);
        } catch (Exception e) {
            log.error("文件路径获取失败",e.getMessage());
        }
        return "http://"+storageServer.getInetSocketAddress().getHostString()+":8888/";
    }
}
