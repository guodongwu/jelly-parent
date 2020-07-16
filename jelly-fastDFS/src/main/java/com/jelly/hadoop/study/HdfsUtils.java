package com.jelly.hadoop.study;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsUtils {
    public static Logger logger = LoggerFactory.getLogger(HdfsUtils.class);

    /**
     * 获取文件系统
     *
     * @param hdfsUri
     * @return
     */
    public static FileSystem getFileSystem(String hdfsUri) {
        Configuration conf = new Configuration();
        FileSystem fs = null;
        if (StringUtils.isBlank(hdfsUri)) {
            Path file;
            TaskAttemptContext context;
            try {
                fs = FileSystem.get(conf);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("连接失败");
            }

        } else {
            try {
                URI uri = new URI(hdfsUri.trim());
                fs = FileSystem.get(uri, conf);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return fs;
    }

    /**
     * 创建文件目录
     *
     * @param hdfsUri
     * @param path
     */
    public static void mkdir(String hdfsUri, String path) {
        FileSystem fs = getFileSystem(hdfsUri);
        try {
            if (StringUtils.isNotBlank(hdfsUri)) {
                path = hdfsUri + path;
            }
            fs.mkdirs(new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 删除文件
     *
     * @param hdfsUri
     * @param path
     */
    public static void delete(String hdfsUri, String path) {
        FileSystem fs = getFileSystem(hdfsUri);
        try {
            if (StringUtils.isNotBlank(hdfsUri)) {
                path = hdfsUri + path;
            }
            fs.delete(new Path(path), true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 按条件遍历文件
     *
     * @param hdfsUri
     * @param path
     * @param filter
     * @return
     */
    public static String[] listFile(String hdfsUri, String path, PathFilter filter) {
        String[] files = new String[0];
        FileSystem fs = null;
        try {
            fs = getFileSystem(hdfsUri);
            if (StringUtils.isNotBlank(hdfsUri)) {
                path = hdfsUri + path;
            }
            FileStatus[] status;
            if (filter != null) {
                status = fs.listStatus(new Path(path), filter);
            } else {
                status = fs.listStatus(new Path(path));
            }
            Path[] listedPaths = FileUtil.stat2Paths(status);
            if (listedPaths != null && listedPaths.length > 0) {
                files = new String[listedPaths.length];
                for (int i = 0; i < files.length; i++) {
                    files[i] = listedPaths[i].toString();
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return files;
    }

    /**
     * 文件上传到hdfs
     *
     * @param hdfsUri
     * @param delSrc
     * @param overwrite
     * @param srcPath
     * @param destPath
     */
    public static void copyFileToHdfs(String hdfsUri, boolean delSrc, boolean overwrite,
                                      String srcPath, String destPath) {
        FileSystem fs = null;
        Path source = new Path(srcPath);
        if (StringUtils.isNotBlank(hdfsUri)) {
            destPath = hdfsUri + destPath;
        }
        Path dest = new Path(destPath);
        try {
            fs = getFileSystem(hdfsUri);
            fs.copyFromLocalFile(source, dest);
            fs.copyFromLocalFile(delSrc, overwrite, source, dest);

        } catch (Exception ex) {
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 下载文件
     *
     * @param hdfsUri
     * @param srcFile
     * @param destFile
     */
    public static void getFile(String hdfsUri, String srcFile, String destFile) {
        FileSystem fs = null;
        // 源文件路径
        if (StringUtils.isNotBlank(hdfsUri)) {
            srcFile = hdfsUri + srcFile;
        }
        Path srcPath = new Path(srcFile);
        Path dstPath = new Path(destFile);
        try {
            // 获取FileSystem对象
            fs = getFileSystem(hdfsUri);
            // 下载hdfs上的文件
            fs.copyToLocalFile(srcPath, dstPath);
            // 释放资源
            fs.close();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取集群节点信息
     *
     * @param hdfsUri
     * @return
     */
    public static DatanodeInfo[] getHdfsNodes(String hdfsUri) {
        DatanodeInfo[] datanodeInfos = new DatanodeInfo[0];
        FileSystem fs = null;
        try {
            fs = getFileSystem(hdfsUri);
            DistributedFileSystem hdfs = (DistributedFileSystem) fs;
            datanodeInfos = hdfs.getDataNodeStats();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return datanodeInfos;
    }

    /**
     * 查找hdfs集群位置
     *
     * @param hdfsUri
     * @param filePath
     * @return
     * @throws IOException
     */
    public static BlockLocation[] getFileBlockLocations(String hdfsUri, String filePath) throws IOException {
        // 文件路径
        if (StringUtils.isNotBlank(hdfsUri)) {
            filePath = hdfsUri + filePath;
        }
        Path path = new Path(filePath);

        // 文件块位置列表
        BlockLocation[] blockLocations = new BlockLocation[0];
        FileSystem fs = null;
        try {
            fs = getFileSystem(hdfsUri);
            FileStatus fileStatus = fs.getFileStatus(path);
            blockLocations = fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fs.close();
        }
        return blockLocations;

    }

    /**
     * 是否存在文件夹
     *
     * @param hdfsUri
     * @param filePath
     * @param isCreate
     * @return
     */
    public boolean existDir(String hdfsUri, String filePath, boolean isCreate) {
        boolean flag = false;
        if (StringUtils.isEmpty(filePath)) {
            return flag;
        }
        FileSystem fs = null;
        try {
            Path path = new Path(filePath);
            fs = getFileSystem(hdfsUri);
            if (isCreate) {
                if (!fs.exists(path)) {
                    fs.mkdirs(path);
                }
            }

            if (fs.getFileStatus(path).isDirectory()) {
                flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
