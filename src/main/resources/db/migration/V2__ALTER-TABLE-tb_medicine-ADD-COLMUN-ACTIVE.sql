alter table tb_medicine add active tinyint;
update tb_medicine set active = 1;