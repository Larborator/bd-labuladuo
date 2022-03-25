package com.douyu.bd.labuladuo.core.model;

import lombok.Data;

/**
 * @author labuladuo
 * @date 2022/3/25
 */
@Data
public class DotUser {
    private Integer oaUid;
    private String oaUsername;
    private Boolean admin = false;

    public DotUser() {
    }

    public DotUser(Builder builder) {
        this.oaUid = builder.oaUid;
        this.oaUsername = builder.oaUsername;
        this.admin = builder.admin;
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer oaUid;
        private String oaUsername;
        private Boolean admin;

        Builder() {
        }

        public Builder oaUid(Integer oaUid) {
            this.oaUid = oaUid;
            return this;
        }

        public Builder oaUsername(String oaUsername) {
            this.oaUsername = oaUsername;
            return this;
        }

        public Builder isAdmin(Boolean admin) {
            this.admin = admin;
            return this;
        }

        public DotUser build() {
            return new DotUser(this);
        }

    }
}
