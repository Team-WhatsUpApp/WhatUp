# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.7.18)
# Database: whatsup_db
# Generation Time: 2017-07-19 14:25:25 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table locations
# ------------------------------------------------------------

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
	(25,'https://s3-media4.fl.yelpcdn.com/bphoto/xkPnx-KQKkMXwSwawx8J6A/o.jpg',X'000000000101000000FCE42840149E58C04BB26900CA743D40','Tomatillos','+12108243005','3210 Broadway St, San Antonio, TX 78209',0,0,'tomatillos-san-antonio','https://www.yelp.com/biz/tomatillos-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',11),
	(27,'https://s3-media3.fl.yelpcdn.com/bphoto/p5Vq5YWiJnfEKOYxrHqHhQ/o.jpg',X'000000000101000000B1F9B836549E58C0328FFCC1C06B3D40','Yeya\'s Antiques & Oddities','+12108275555','1423 E Commerce, San Antonio, TX 78205',0,0,'yeyas-antiques-and-oddities-san-antonio','https://www.yelp.com/biz/yeyas-antiques-and-oddities-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',1),
	(28,'https://s3-media2.fl.yelpcdn.com/bphoto/aesdJRGdF6FA55sS345AZw/o.jpg',X'000000000101000000030000A04EA158C00000006098753D40','Danny Boy\'s Hamburgers','+12107361665','1537 W Summit Ave, San Antonio, TX 78201',0,0,'danny-boys-hamburgers-san-antonio','https://www.yelp.com/biz/danny-boys-hamburgers-san-antonio?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',9),
	(29,'https://s3-media2.fl.yelpcdn.com/bphoto/Oqphalsreqz4GXESBaOn7g/o.jpg',X'00000000010100000000000060F8A458C0FDFFFFBF55733D40','Barrio Barista','+12105195403','3735 Culebra Rd, San Antonio, TX 78228',0,0,'barrio-barista-san-antonio-2','https://www.yelp.com/biz/barrio-barista-san-antonio-2?adjust_creative=qoki5XUClSAHUg-8xN8eTg&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=qoki5XUClSAHUg-8xN8eTg',5);

/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping routines (PROCEDURE) for database 'whatsup_db'
--
DELIMITER ;;

DELIMITER ;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
