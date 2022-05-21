package com.rl.spring_security.java8;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ren
 * @description TODO
 * @date 2022/1/10 9:20
 */
public class Streams {
    private enum Status {
        OPEN, CLOSED
    };

    public static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points){
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public static void main(String[] args) {
//        final Collection<Task> tasks = Arrays.asList(
//                new Task(Status.OPEN, 5),
//                new Task(Status.OPEN, 13),
//                new Task(Status.CLOSED, 8)
//        );
//
//        // 计算为open状态求和
//        final long totalPointsOfOpenTasks = tasks
//                .stream()
//                .filter(task -> task.getStatus() == Status.OPEN)
//                .mapToInt(Task::getPoints)
//                .sum();
//        System.out.println("Total points: " + totalPointsOfOpenTasks);
//
//        // 求和
//        final double totalPoints = tasks
//                .stream()
//                .parallel()
//                .map(Task::getPoints)
//                .reduce(0, Integer::sum);
//        System.out.println("Total points (all tasks): " + totalPoints);
//
//        // 按status分组
//        final Map<Status, List<Task>> map = tasks
//                .stream()
//                .collect(Collectors.groupingBy(Task::getStatus));
//        System.out.println(map);
//
//        // 计算权重
//        final Collection<String> result = tasks
//                .stream()
//                .mapToInt(Task::getPoints)
//                .asLongStream()
//                .mapToDouble(points -> points/totalPoints)
//                .boxed()
//                .mapToLong(weight -> (long) (weight*100))
//                .mapToObj(percentage -> percentage + "%")
//                .collect(Collectors.toList());
//        System.out.println(result);

        // 读文件
//        String filename = "D:\\aaa\\啦啦啦.csv";
//        final Path path = new File(filename).toPath();
//        try(Stream<String> lines = Files.lines(path, Charset.forName("GBK"))) {
//            lines.onClose(()-> System.out.println("Done!")).forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 日期处理
        // time操作
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("---------------");

        // get the local date
        final LocalDate date = LocalDate.now();
        final LocalDate dateFromClock = LocalDate.now(clock);
        System.out.println(date);
        System.out.println(dateFromClock);
        System.out.println("---------------");

        // get the local time
        final LocalTime time = LocalTime.now();
        final LocalTime timeFromClock = LocalTime.now(clock);
        System.out.println(time);
        System.out.println(timeFromClock);
        System.out.println("---------------");

        // get the local date/time
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now(clock);
        System.out.println(datetime);
        System.out.println(datetimeFromClock);
        System.out.println("---------------");

        // 获取特定时区的datetime
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now(clock);
        final ZonedDateTime zonedDateTimeFromZone = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println(zonedDateTime);
        System.out.println(zonedDatetimeFromClock);
        System.out.println(zonedDateTimeFromZone);
        System.out.println("---------------");

        // 计算两个日期之间隔的天数
        LocalDateTime from = LocalDateTime.of(2014, 4, 16, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2015,4,16,23,59,59);
        final Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println("---------------");
        System.out.println("---------------------------------------------");

        // 对Base64进行编码支持
        // 新的Base64API也支持URL和MINE的编码解码。
        // Base64.getUrlEncoder() / Base64.getUrlDecoder()
        // Base64.getMimeEncoder() / Base64.getMimeDecoder()
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String (
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);
        System.out.println(decoded);
        System.out.println("---------------------------------------------");

        // 并行数组
        long[] arrayOfLong = new long[20000];
        Arrays.parallelSetAll(arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt(10000));
        Arrays.stream(arrayOfLong).limit(10).forEach(
                i -> System.out.print(i + " "));
        System.out.println();

        Arrays.parallelSort(arrayOfLong, Collections.reverseOrder());
        Arrays.stream(arrayOfLong).limit(15).forEach(
                i -> System.out.print(i + " "));
        System.out.println();
    }
}
