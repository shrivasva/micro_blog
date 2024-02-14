CREATE TABLE IF NOT EXISTS APP_BLOG_CONTENT (
    id SERIAL PRIMARY KEY,
    created_date timestamp,
    updated_date timestamp,
    active smallint,
    blog bytea,
    user_id BIGINT,
    CONSTRAINT fk_user_id_blog FOREIGN KEY (user_id) REFERENCES APP_USERS(id)
);

CREATE TABLE IF NOT EXISTS app_engagement_comments (
    id SERIAL PRIMARY KEY,
    comment_date timestamp,
    updated_date timestamp,
    active smallint,
    comment bytea,
    blog_id BIGINT,
    user_id BIGINT,
    comment_id BIGINT,
    CONSTRAINT fk_user_id_com FOREIGN KEY (user_id) REFERENCES APP_USERS(id),
    CONSTRAINT fk_blog_id_com FOREIGN KEY (blog_id) REFERENCES APP_BLOG_CONTENT(id),
    CONSTRAINT fk_comment_id_com FOREIGN KEY (comment_id) REFERENCES app_engagement_comments(id)
);

CREATE TABLE IF NOT EXISTS app_engagement_likes (
    id SERIAL PRIMARY KEY,
    like_date timestamp,
    active smallint,
    likes smallint,
    blog_id BIGINT,
    user_id BIGINT,
    comment_id BIGINT,
    CONSTRAINT fk_user_id_lik FOREIGN KEY (user_id) REFERENCES APP_USERS(id),
    CONSTRAINT fk_blog_id_lik FOREIGN KEY (blog_id) REFERENCES APP_BLOG_CONTENT(id),
    CONSTRAINT fk_comment_id_lik FOREIGN KEY (comment_id) REFERENCES app_engagement_comments(id)
);