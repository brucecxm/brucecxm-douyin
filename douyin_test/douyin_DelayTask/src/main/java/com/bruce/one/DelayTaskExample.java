package com.bruce.one;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 延迟任务执行方法汇总
 */
public class DelayTaskExample {
    // 存放定时任务
    private static Map<String, Long> _TaskMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("程序启动时间：" + LocalDateTime.now());
        // 添加定时任务
        _TaskMap.put("task-1", Instant.now().plusSeconds(3).toEpochMilli()); // 延迟 3s
        _TaskMap.put("task-2", Instant.now().plusSeconds(6).toEpochMilli()); // 延迟 6s

        // 调用无限循环实现延迟任务
        loopTask();
    }

    /**
     * 无限循环实现延迟任务
     */
    public static void loopTask() {
        Long itemLong = 0L;
        while (true) {
            Iterator it = _TaskMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                itemLong = (Long) entry.getValue();
                // 有任务需要执行
                if (Instant.now().toEpochMilli() >= itemLong) {
                    // 延迟任务，业务逻辑执行
                    System.out.println("执行任务：" + entry.getKey() +
                            " ，执行时间：" + LocalDateTime.now());
                    // 删除任务
                    _TaskMap.remove(entry.getKey());
                }
            }
        }
    }
}
