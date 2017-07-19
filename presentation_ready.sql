
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;




LOCK TABLES `coupons` WRITE;
/*!40000 ALTER TABLE `coupons` DISABLE KEYS */;

INSERT INTO `coupons` (`id`, `code`, `description`, `end_datetime`, `remaining_uses`, `restrictions`, `start_datetime`, `title`, `value`, `vendor_id`)
VALUES
	(1,'TACOTACO','Who doesn\'t love tacos?',NULL,50,'No more than 10 per person!',NULL,'Buy one, get one','50/50',4),
	(2,'PIZZAGALORE','Everyone loves pizza!',NULL,200,'There are none!',NULL,'Hot pizzas melt in your mouth','30% off',9),
	(11,'GLUG','All drinks are half off, all day!',NULL,300,'5 uses per customer',NULL,'Thirsty Thursday','50% off',8),
	(12,'FUNFRIDAY','Yay! It\'s Friday!',NULL,75,'There are none!',NULL,'Fun Friday','Who knows?',11),
	(15,'CLAPCLAPCLAP','Who doesn\'t like hot food and loud music? Come on down, get down, and get a discount on your bill!',NULL,100,'Can\'t do the sprinkler',NULL,'Get schwifty','25% off',11),
	(17,'THURSDAY','It\'s getting hot out there. Get out of the summer heat and have fun on nickel shot night!',NULL,150,'No more than 3 per person',NULL,'Thirsty Thursday','Shots are 5¢',10);

/*!40000 ALTER TABLE `coupons` ENABLE KEYS */;
UNLOCK TABLES;





LOCK TABLES `location_has_coupons` WRITE;
/*!40000 ALTER TABLE `location_has_coupons` DISABLE KEYS */;

INSERT INTO `location_has_coupons` (`location_id`, `coupon_id`)
VALUES
	(5,15),
	(5,17);

/*!40000 ALTER TABLE `location_has_coupons` ENABLE KEYS */;
UNLOCK TABLES;




LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;

INSERT INTO `locations` (`id`, `image_url`, `location`, `name`, `phone_number`, `street_address`, `x`, `y`, `yelp_id`, `yelp_url`, `vendor_id`)
VALUES
	(2,'https://s3-media3.fl.yelpcdn.com/bphoto/tIrzyaUuXJmHwIfbnY3PVw/o.jpg',X'000000000101000000A4880CAB789F58C0A2B437F8C26C3D40','The Esquire Tavern','+12102222521','155 E Commerce St, San Antonio, TX 78205',0,0,'the-esquire-tavern-san-antonio','https://www.yelp.com/biz/the-esquire-tavern-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',2),
	(3,'https://s3-media1.fl.yelpcdn.com/bphoto/ulOfwAwYOPJSNl6Yq98ayA/o.jpg',X'0000000001010000006A4912D9F39E58C0CB5E3A086C6F3D40','Paramour','+12103409880','102 9th St, San Antonio, TX 78215',0,0,'paramour-san-antonio','https://www.yelp.com/biz/paramour-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',3),
	(4,'https://s3-media3.fl.yelpcdn.com/bphoto/-C7V4Wbdgqhktyvawz-AoQ/o.jpg',X'00000000010100000021BDA8B3ACA958C064AAE11DBF693D40','Asia Kitchen','+12106730662','1739 SW Loop 410, San Antonio, TX 78227',0,0,'asia-kitchen-san-antonio','https://www.yelp.com/biz/asia-kitchen-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',4),
	(5,'https://s3-media1.fl.yelpcdn.com/bphoto/f6fIEaH6yD8AbC0YljswlQ/o.jpg',X'000000000101000000325C2EE850A958C013C573E83C6B3D40','Apetitos Mexican Restaurant','+12106758020','1615 Meadow Way, San Antonio, TX 78227',0,0,'apetitos-mexican-restaurant-san-antonio','https://www.yelp.com/biz/apetitos-mexican-restaurant-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',11),
	(6,'https://s3-media4.fl.yelpcdn.com/bphoto/x-xehos45tKbsR8yX1a8GQ/o.jpg',X'0000000001010000003108AC1C5AA458C03C31EBC550863D40','Golden Wok','+12106158282','8822 Wurzbach Rd, San Antonio, TX 78240',0,0,'golden-wok-san-antonio','https://www.yelp.com/biz/golden-wok-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',6),
	(7,'https://s3-media3.fl.yelpcdn.com/bphoto/MBcOccrbjcLSv0zXRHcC6A/o.jpg',X'000000000101000000459E245D339558C0BEBC00FBE8883D40','China Garden','+12106586688','8022 Kitty Hawk Rd, Converse, TX 78109',0,0,'china-garden-converse','https://www.yelp.com/biz/china-garden-converse?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',7),
	(8,'https://s3-media3.fl.yelpcdn.com/bphoto/temCEt4Htkhj0UXqRaPv1g/o.jpg',X'0000000001010000006F1118EB1B9F58C057B3CEF8BE903D40','Saeb Thai & Noodles','+12105453354','226 W Bitters Rd, San Antonio, TX 78216',0,0,'saeb-thai-and-noodles-san-antonio','https://www.yelp.com/biz/saeb-thai-and-noodles-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',8),
	(10,'https://s3-media3.fl.yelpcdn.com/bphoto/50iI7tV36xOaRn3hPdOvGg/o.jpg',X'0000000001010000003CA3AD4A22A758C0E28FA2CEDC973D40','Whiskey Cake','+12102368095','15900 La Cantera Pkwy, San Antonio, TX 78256',0,0,'whiskey-cake-san-antonio-5','https://www.yelp.com/biz/whiskey-cake-san-antonio-5?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',10),
	(22,'https://s3-media2.fl.yelpcdn.com/bphoto/4IcftQAoTOUhSefJOnRDxg/o.jpg',X'000000000101000000F08AE07F2B9F58C0F0C4AC1743693D40','Bliss','+12102252547','926 S Presa St, San Antonio, TX 78210',0,0,'bliss-san-antonio','https://www.yelp.com/biz/bliss-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',1),
	(23,'https://s3-media1.fl.yelpcdn.com/bphoto/IKN7H1F4RKJ8CUpNOykhYw/o.jpg',X'000000000101000000000000A02D9E58C0F5FFFF3FDE6C3D40','Dignowity Meats On Houston Street','+12104621496','1701 E Houston St, San Antonio, TX 78202',0,0,'dignowity-meats-on-houston-street-san-antonio','https://www.yelp.com/biz/dignowity-meats-on-houston-street-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',1),
	(24,'https://s3-media1.fl.yelpcdn.com/bphoto/C2V1vMvEs9cdtSSfyj9Eyg/o.jpg',X'0000000001010000002D84F7857F9F58C062126D0BC46C3D40','Bella On the River','+12104042355','106 River Walk St, San Antonio, TX 78205',0,0,'bella-on-the-river-san-antonio','https://www.yelp.com/biz/bella-on-the-river-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',1),
	(25,'https://s3-media4.fl.yelpcdn.com/bphoto/xkPnx-KQKkMXwSwawx8J6A/o.jpg',X'000000000101000000FCE42840149E58C04BB26900CA743D40','Tomatillos','+12108243005','3210 Broadway St, San Antonio, TX 78209',0,0,'tomatillos-san-antonio','https://www.yelp.com/biz/tomatillos-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',12),
	(27,'https://s3-media3.fl.yelpcdn.com/bphoto/p5Vq5YWiJnfEKOYxrHqHhQ/o.jpg',X'000000000101000000B1F9B836549E58C0328FFCC1C06B3D40','Yeya\'s Antiques & Oddities','+12108275555','1423 E Commerce, San Antonio, TX 78205',0,0,'yeyas-antiques-and-oddities-san-antonio','https://www.yelp.com/biz/yeyas-antiques-and-oddities-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',1),
	(28,'https://s3-media2.fl.yelpcdn.com/bphoto/aesdJRGdF6FA55sS345AZw/o.jpg',X'000000000101000000030000A04EA158C00000006098753D40','Danny Boy\'s Hamburgers','+12107361665','1537 W Summit Ave, San Antonio, TX 78201',0,0,'danny-boys-hamburgers-san-antonio','https://www.yelp.com/biz/danny-boys-hamburgers-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',9),
	(29,'https://s3-media2.fl.yelpcdn.com/bphoto/Oqphalsreqz4GXESBaOn7g/o.jpg',X'00000000010100000000000060F8A458C0FDFFFFBF55733D40','Barrio Barista','+12105195403','3735 Culebra Rd, San Antonio, TX 78228',0,0,'barrio-barista-san-antonio-2','https://www.yelp.com/biz/barrio-barista-san-antonio-2?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',5);

/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;



LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;

INSERT INTO `user_roles` (`id`, `role`, `user_id`)
VALUES
	(1,'ROLE_VENDOR',1),
	(2,'ROLE_VENDOR',2),
	(3,'ROLE_VENDOR',3),
	(4,'ROLE_USER',4),
	(5,'ROLE_VENDOR',5),
	(6,'ROLE_VENDOR',6),
	(7,'ROLE_VENDOR',7),
	(8,'ROLE_VENDOR',8),
	(9,'ROLE_VENDOR',9),
	(10,'ROLE_USER',10),
	(11,'ROLE_VENDOR',11),
	(12,'ROLE_USER',12),
	(13,'ROLE_VENDOR',13),
	(14,'ROLE_USER',14),
	(15,'ROLE_USER',15),
	(16,'ROLE_USER',16),
	(17,'ROLE_USER',17),
	(18,'ROLE_VENDOR',18),
	(19,'ROLE_USER',18),
	(23,'ROLE_USER',23),
	(24,'ROLE_VENDOR',25),
	(25,'ROLE_USER',26),
	(26,'ROLE_VENDOR',27);

/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `create_time`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `username`)
VALUES
	(1,'1985-06-17 00:06:48','yost.kariane@example.net','Vallie','Dickens','2becbe7c1050ea135b976b4add27915a','153.489.3742x2867','yazmin.wiegand'),
	(2,'1973-12-25 21:56:59','nvandervort@example.com','Major','Harvey','966283bfb32461b7e6ec650cfca65e92','450.339.4397','lorenzo.jakubows'),
	(3,'1998-12-31 18:42:31','layla.dach@example.org','Otilia','Price','ccda89f6a22d82f512b6a1face08ff79','619-469-7438x197','kcummerata'),
	(4,'2012-05-14 10:59:03','pkling@example.org','Anastasia','Ritchie','5dc8a0b7ce4121874479ae5863b751fa','028-116-5031x4906','valentin.schuste'),
	(5,'2017-07-16 15:54:56','gerry08@example.net','Beyonce','Knowles','9525c963370fdaa5e19a94886ea489c3','1-846-046-0781','yonce'),
	(6,'2000-11-05 21:00:30','gail94@example.com','Justen','Smitham','34e23baf6af145ed4edd8eed3cb9aabc','052-713-5691x6378','bhuel'),
	(7,'2014-12-17 16:35:50','schiller.amalia@example.org','Kip','Nikolaus','dd288302f5e8b30708ca6acdd3ed25b5','1-850-397-4191','elemke'),
	(8,'1971-04-19 01:55:28','windler.stacey@example.org','Eldred','Dooley','ed450cf301d7c2b83a1baa30e63d3d03','1-170-457-6568x3731','greenfelder.cath'),
	(9,'1989-01-24 07:44:01','kmurazik@example.org','Oral','Murphy','945748b1d085477d7a03e52bd0fbcc0f','1-164-187-3560x75908','enola.weimann'),
	(10,'1992-04-24 23:35:40','murphy.daniella@example.org','Rosamond','Barrows','53dd4cc898db6fb2781d528aa236cf8f','1-533-645-3512x02931','rodriguez.einar'),
	(11,'2016-02-11 00:45:20','julius.kilback@example.net','Domenico','Welch','4b7297ff2a1f2d015534a52b557ddcca','878.401.6757','frederic.crooks'),
	(12,'1971-10-26 09:43:01','zula.wyman@example.com','Anjali','Lakin','fcaf5930d8626ca6e4b7f43c34daef4e','125.891.9263','uriel.larson'),
	(13,'1986-06-30 18:38:53','brittany98@example.net','Jevon','Hilpert','b8d9a206cb219cd81c0b5e2bf922dd01','(075)150-3851x92948','felicity98'),
	(14,'1977-12-10 16:18:50','swift.kattie@example.com','Emelia','Gorczany','c1bfccb02a01767f1cccae05671d1515','(516)110-8464x3719','vicente65'),
	(15,'2008-05-10 18:44:46','carolyne.stokes@example.org','Mohammad','Casper','bea3a3ffb6f55e0137256cc67890cd4e','(956)396-0235x616','santina.borer'),
	(16,'1984-12-01 05:52:01','glenna.pfeffer@example.org','Laurence','Huel','7001e6aae0ccddc626eb571970a98dbd','1-453-698-6426','rstreich'),
	(17,'2010-12-18 05:12:41','swaniawski.keyshawn@example.com','Kassandra','Smith','100ecf175ba9a390ce4729d07bdc02af','754-416-4566x97983','vromaguera'),
	(18,'2017-07-17 09:18:44','mosesesis@live.com','Moses','Franco','$2a$10$i0U2xVELc8k5NLfqcdEXLODpiSCiEv9Lr79qrpbaJvL4EbIS3qyHG','2104180614','mo'),
	(19,'2017-07-17 10:11:45','del@gmail.com',NULL,NULL,'$2a$10$iT4QQpqGRLd6UN/ig1BmTeojH8sAWQSgDaaaEyciW/N.rqzLhPtLq','336303276','del'),
	(20,'2017-07-17 10:12:20','del@gmail.com',NULL,NULL,'$2a$10$vdMqeAqX/PIVuy0/ISHBEuykf/euTDKsrYmP1VO77Mu38XxJxaM1C','336303276','del'),
	(21,'2017-07-17 10:15:30','mosesesis@live.com',NULL,NULL,'$2a$10$HLq3HPGt.3vP1ixwg2zlruSZ8E3kAbhDabuK2DL6EbSOPoW2xi2ou','2104180614','momo'),
	(22,'2017-07-17 10:16:12','mosesf@outlook.com',NULL,NULL,'$2a$10$tSzoMEk3JYrsa/XSQ018KOptVf.aZEZAq7djDpefG/4f6kc.xDBcm','2105551234','mrmmomo'),
	(23,'2017-07-17 13:55:13','mosesf@outlook.com',NULL,NULL,'$2a$10$e0adJs7f/jHVHSC/iBhh2.ikpDho/mGdQcJ3C6jTLUvg9to9zOvT.','2104180614','ohmo'),
	(24,'2017-07-17 15:56:31','test@test.com',NULL,NULL,'$2a$10$YILXyNaD8CyZnH0R60HE7uN5nivm/YWrYpN0z7N6iOUAtJCCdCEda','2105551234','test'),
	(25,'2017-07-17 16:00:30','tester@hash.com',NULL,NULL,'$2a$10$5Lb0P0RSUEXxQaKl9Vxr0e3CZKR0D36RgD7FgQr87MzBHSOSvhHLm','2105551234','tested'),
	(26,'2017-07-17 16:08:40','luis@codeup.com',NULL,NULL,'$2a$10$pauV/5GXQQT27SmxzAJxR./L1mJnmMsuZHsuWLeBvZbUbB.uoh2IK','1234','luis'),
	(27,'2017-07-17 16:09:42','vendor@codeup.com',NULL,NULL,'$2a$10$lRMAuEjh9BnkcLuKoQf3pu12B3VFyU8nKMePnyJ6k98xX4JqoTy0C','1234','vendor');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;


LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;

INSERT INTO `vendors` (`id`, `display_name`, `validated`, `owner_id`)
VALUES
	(1,'SA Foodies',b'1',1),
	(2,'Luxue Nosh',b'1',3),
	(3,'Deckow, Johns and Leffler',b'1',6),
	(4,'Franecki-Rodriguez',b'1',2),
	(5,'Juicy Enterprises',b'1',5),
	(6,'Nikolaus, Turner and Harvey',b'1',7),
	(7,'Purdy Group',b'1',8),
	(8,'Hane PLC',b'0',11),
	(9,'Waelchi, Kub and McLaughlin',b'1',13),
	(10,'Swift-Orn',b'0',9),
	(11,'Mo Foods',b'1',18),
	(12,'vendor name',b'0',27);

/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
