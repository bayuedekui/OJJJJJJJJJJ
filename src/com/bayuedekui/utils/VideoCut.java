package com.bayuedekui.utils;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoCut {
    public static void main(String[] args) throws IOException {
        String videoPath = "E:\\flink+clikchouse实时数仓\\need\\";
        String newVideoPath = videoPath + "NEW\\";

        String ffmpegPath = "D:\\ffmpeg-4.4.1-essentials_build\\bin\\ffmpeg.exe";

        File file = new File(videoPath);
        File[] files = file.listFiles();

        File newDir = new File(newVideoPath);
        if (!newDir.exists()) {
            newDir.mkdir();
        }

        String startTime = "00:00:00";
        int endCut = 17;

        Runtime runtime = Runtime.getRuntime();

        for (File f : files) {
            if (f.isDirectory()) {
                continue;
            }
            String videoLen = getVideoTime(videoPath + f.getName(), ffmpegPath);
            String len = transferSeconds(videoLen, endCut);

            List<String> cmds = new ArrayList();
            cmds.add(ffmpegPath);
            cmds.add(" -i ");
            cmds.add(videoPath + f.getName());
            cmds.add(" -ss ");
            cmds.add(startTime);
            cmds.add(" -t ");
            cmds.add(len);
            cmds.add(" -c:v copy -c:a copy ");
            cmds.add(newVideoPath + f.getName());
            String cmd = StringUtils.join(cmds, "");

            runtime.exec(cmd);

            System.out.println(cmd);
        }
    }


    /**
     * 获取视频时间
     *
     * @param video_path  视频路径
     * @param ffmpeg_path ffmpeg安装路径
     * @return
     */
    public static String getVideoTime(String video_path, String ffmpeg_path) {
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(video_path);
        System.out.println("命令行:" + ffmpeg_path + " -i " + video_path);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            final Process p = builder.start();

            //从输入流中读取视频信息
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            //从视频信息中解析时长
            String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
            Pattern pattern = Pattern.compile(regexDuration);
            Matcher m = pattern.matcher(sb.toString());
            if (m.find()) {

                //System.out.println(video_path+",视频时长："+m.group(1)+", 开始时间："+m.group(2)+",比特率："+m.group(3)+"kb/s");
                return m.group(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String transferSeconds(String str, int cut) {
        int res = 0;
        String[] split = str.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2].substring(0, 2));
        res += hour * 3600 + minute * 60 + second - cut;
        return String.valueOf(res);
    }
}

