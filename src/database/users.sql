CREATE TABLE `users`
(
    id         bigint NOT NULL AUTO_INCREMENT,
    name       varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    email      varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    created_at datetime                                DEFAULT CURRENT_TIMESTAMP,
    updated_at datetime                                DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
