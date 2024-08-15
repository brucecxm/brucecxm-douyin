package com.bruce.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bruce.video.entity.Video;
import com.bruce.video.entity.VideoWithAvatar;
import com.bruce.service.VideoService;
import com.bruce.music.MusicClient;
import com.bruce.user.UserClient;
import com.bruce.utils.ThreadLocalUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (Video)表控制层
 *
 * @author makejava
 * @since 2024-06-25 13:03:23
 */
@RestController
@RequestMapping("/video")
public class VideoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;

    @Autowired
    private UserClient userClient;

    @Autowired
    private MusicClient musicClient;



    /**
     * 分页查询所有数据
     *

     * @return 所有数据
     */
    @GetMapping("/one")
    public R getone() {
       List<Video> videos= this.videoService.list();
        System.out.println("one");

        List<VideoWithAvatar> videosWithAvatar = new ArrayList<>();
        for (Video video : videos) {
            VideoWithAvatar videoWithAvatar = new VideoWithAvatar();
            // 复制 Video 对象的属性到 VideoWithAvatar 对象
            BeanUtils.copyProperties(video, videoWithAvatar);
            Map<String, String> map = ThreadLocalUtil.get();

            String avatar=userClient.avatar(video.getAuthId(),map.get("Authorization")).getUserPic();
            // 设置 avatar 字段
            videoWithAvatar.setAvatar(avatar); // 这是第60行
            String nickname=userClient.avatar(video.getAuthId(),map.get("Authorization")).getNickname();
            videoWithAvatar.setNickname(nickname); // 这是第60行
String musicAvatar=musicClient.avatar(video.getMusicId());
videoWithAvatar.setMusicAvatar(musicAvatar); //
            // 添加到结果集中
            videosWithAvatar.add(videoWithAvatar);
        }
        return success(videosWithAvatar);
    }

    @GetMapping("/more")
    public R getmore() {
        List<Video> videos= this.videoService.list();
        System.out.println("more");

        List<VideoWithAvatar> videosWithAvatar = new ArrayList<>();
        for (Video video : videos) {
            VideoWithAvatar videoWithAvatar = new VideoWithAvatar();
            // 复制 Video 对象的属性到 VideoWithAvatar 对象
            BeanUtils.copyProperties(video, videoWithAvatar);
            Map<String, String> map = ThreadLocalUtil.get();
            String avatar=userClient.avatar(video.getAuthId(),map.get("Authorization")).getUserPic();
            // 设置 avatar 字段
            videoWithAvatar.setAvatar(avatar); // 这是第60行
            String nickname=userClient.avatar(video.getAuthId(),map.get("Authorization")).getNickname();
            videoWithAvatar.setNickname(nickname); // 这是第60行
            String musicAvatar=musicClient.avatar(video.getMusicId());
            videoWithAvatar.setMusicAvatar(musicAvatar); //
            // 添加到结果集中
            videosWithAvatar.add(videoWithAvatar);
        }
        return success(videosWithAvatar);
    }





    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param video 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Video> page, Video video) {
        return success(this.videoService.page(page, new QueryWrapper<>(video)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.videoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param video 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Video video) {
        return success(this.videoService.save(video));
    }

    /**
     * 修改数据
     *
     * @param video 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Video video) {
        return success(this.videoService.updateById(video));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.videoService.removeByIds(idList));
    }
}

