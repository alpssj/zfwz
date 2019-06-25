package com.example.demo.domain;

public class Video {

    private int video_id;
    private String video_name;
    private String video_link;
    private String video_kind;

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getVideo_kind() {
        return video_kind;
    }

    public void setVideo_kind(String video_kind) {
        this.video_kind = video_kind;
    }
}
