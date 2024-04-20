CREATE TABLE `posts`
(
    id         bigint NOT NULL,
    user_id    bigint                                  DEFAULT NULL,
    title      varchar(30) COLLATE utf8mb4_unicode_ci  DEFAULT NULL,
    content    varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    created_at datetime                                DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
