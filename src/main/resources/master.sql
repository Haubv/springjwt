INSERT INTO `demo_springjwt`.`t_role` (`name`) VALUES
 ('ADMIN'), ('USER'), ('AUTHOR'), ('EDITOR');
INSERT INTO `demo_springjwt`.`t_user` (`username`, `password`) VALUES
 ('hau', '$2a$10$VObHxmxycf0.QJNXlwqEc.mFZ.iYkS5V4zAJ0xdIMSoEYoW18O7cu'); -- hau/123456
INSERT INTO `demo_springjwt`.`t_user_role` (`user_id`, `role_id`) VALUES
 (1, 1);
 INSERT INTO `demo_springjwt`.`t_type_book` (`type_name`) VALUES
 ('Tình cảm'), ('Kinh dị'), ('Khoa học viễn tưởng'), ('Trinh thám');