-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.42-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cts_exec
--

CREATE DATABASE IF NOT EXISTS cts_exec;
USE cts_exec;

--
-- Definition of table `executiontest`
--

DROP TABLE IF EXISTS `executiontest`;
CREATE TABLE `executiontest` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `startdatatime` varchar(10) NOT NULL,
  `finishdatatime` varchar(10) NOT NULL,
  `iduser` int(10) unsigned NOT NULL,
  `starttime` varchar(10) NOT NULL,
  `finishtime` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `executiontest`
--

/*!40000 ALTER TABLE `executiontest` DISABLE KEYS */;
INSERT INTO `executiontest` (`id`,`startdatatime`,`finishdatatime`,`iduser`,`starttime`,`finishtime`) VALUES 
 (72,'23/05/2012','23/05/2012',0,'12:51:56','12:56:34'),
 (73,'23/05/2012','',0,'12:59:04',''),
 (74,'23/05/2012','',0,'01:05:54',''),
 (75,'23/05/2012','',0,'01:09:46',''),
 (76,'23/05/2012','23/05/2012',0,'01:11:43','01:12:52'),
 (77,'23/05/2012','',0,'01:22:36',''),
 (78,'23/05/2012','',0,'01:23:18',''),
 (79,'23/05/2012','',0,'01:24:18',''),
 (80,'23/05/2012','',0,'01:34:24',''),
 (81,'23/05/2012','',0,'01:35:25',''),
 (82,'23/05/2012','',0,'01:45:25',''),
 (83,'23/05/2012','',0,'01:54:38',''),
 (84,'23/05/2012','23/05/2012',0,'11:01:02','11:01:42'),
 (85,'23/05/2012','23/05/2012',0,'11:46:03','11:46:03'),
 (86,'23/05/2012','',0,'01:09:06',''),
 (87,'23/05/2012','23/05/2012',0,'01:19:54','01:21:17'),
 (88,'23/05/2012','23/05/2012',0,'01:27:11','01:27:40'),
 (89,'23/05/2012','23/05/2012',0,'01:30:03','01:30:48'),
 (90,'23/05/2012','23/05/2012',0,'01:32:10','01:32:36'),
 (91,'23/05/2012','23/05/2012',0,'01:36:36','01:37:01'),
 (92,'23/05/2012','23/05/2012',0,'02:56:05','02:56:46'),
 (93,'23/05/2012','23/05/2012',0,'02:59:43','03:00:04'),
 (94,'23/05/2012','',0,'04:37:47',''),
 (95,'23/05/2012','',0,'04:40:34',''),
 (96,'23/05/2012','',0,'04:52:56',''),
 (97,'23/05/2012','',0,'06:34:55',''),
 (98,'23/05/2012','',0,'06:36:08',''),
 (99,'23/05/2012','',0,'06:36:46',''),
 (100,'23/05/2012','',0,'06:41:48',''),
 (101,'23/05/2012','',0,'06:42:03',''),
 (102,'23/05/2012','',0,'07:07:53',''),
 (103,'23/05/2012','',0,'08:04:05',''),
 (104,'23/05/2012','23/05/2012',0,'08:47:07','09:21:47'),
 (105,'23/05/2012','23/05/2012',0,'09:29:13','09:31:00'),
 (106,'23/05/2012','23/05/2012',0,'09:46:07','10:11:32'),
 (107,'24/05/2012','',0,'11:49:52',''),
 (108,'24/05/2012','24/05/2012',0,'11:50:17','11:53:16'),
 (109,'24/05/2012','24/05/2012',0,'01:53:43','01:55:52'),
 (110,'24/05/2012','24/05/2012',0,'02:36:23','02:38:40'),
 (111,'24/05/2012','24/05/2012',0,'05:44:47','05:45:34'),
 (112,'24/05/2012','24/05/2012',0,'05:46:44','05:52:59'),
 (113,'24/05/2012','',0,'06:02:34',''),
 (114,'24/05/2012','',0,'06:03:17','');
/*!40000 ALTER TABLE `executiontest` ENABLE KEYS */;


--
-- Definition of table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idexec` int(11) NOT NULL,
  `idtest` int(11) NOT NULL,
  `resulttest` varchar(200) NOT NULL,
  `comment` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` (`id`,`idexec`,`idtest`,`resulttest`,`comment`) VALUES 
 (1,92,68,'yes','dsadsad'),
 (2,92,64,'yes','sadasdas'),
 (3,92,66,'no','sadsa'),
 (4,93,68,'not supported','dsadasd'),
 (5,93,64,'no','dsads'),
 (6,93,66,'yes','dwadads'),
 (7,103,68,'yes','dsad'),
 (8,103,66,'yes','sadas'),
 (9,103,64,'yes','csddasa'),
 (10,104,68,'yes','passou'),
 (11,104,66,'yes','sdsds'),
 (12,104,64,'yes','cddsfds'),
 (13,104,65,'yes','dsadsds'),
 (14,104,56,'yes','cdasdfd'),
 (15,104,67,'yes','dsadsafds'),
 (16,104,73,'yes','dsafsdfds'),
 (17,104,74,'yes','cdscdsfds'),
 (18,104,72,'yes','dsadasda'),
 (19,104,71,'yes','czczxczx'),
 (20,105,68,'yes','dsdfdsfs'),
 (21,105,66,'no','dsdffds'),
 (22,105,64,'not supported','dsafdsfsd'),
 (23,105,65,'conditional pass - provide explanation in adjacent cell','dfsdfsdfds'),
 (24,105,56,'no','dsfdsfdf'),
 (25,105,67,'yes','fdsfsdfdsfds'),
 (26,105,73,'yes','dsffdsfds'),
 (27,105,74,'conditional pass - provide explanation in adjacent cell','dfdsfdsfds'),
 (28,105,72,'no','dsfdsfdsfds'),
 (29,105,71,'not supported','fdfdfd'),
 (30,106,68,'yes',''),
 (31,106,66,'yes',''),
 (32,106,64,'yes',''),
 (33,106,65,'yes',''),
 (34,106,56,'yes',''),
 (35,106,67,'yes',''),
 (36,106,73,'yes',''),
 (37,106,74,'yes',''),
 (38,106,72,'yes',''),
 (39,106,71,'yes',''),
 (40,108,68,'yes','sdds'),
 (41,108,66,'yes','dfdsfdsfd'),
 (42,108,64,'yes','dsadas'),
 (43,108,65,'yes','dsadsa'),
 (44,108,56,'yes','dsadsa'),
 (45,108,67,'yes','asdasdas'),
 (46,108,73,'yes','saddsadsa'),
 (47,108,74,'yes','adsfdsfdsf'),
 (48,108,72,'yes','dsadsasa'),
 (49,108,71,'yes','dadasdsa'),
 (50,109,68,'yes','comment'),
 (51,109,66,'no','comment'),
 (52,109,64,'conditional pass - provide explanation in adjacent cell','comment'),
 (53,109,65,'yes','comment'),
 (54,109,56,'not supported','comment'),
 (55,109,67,'no','comment'),
 (56,109,73,'conditional pass - provide explanation in adjacent cell','comment'),
 (57,109,74,'no','comment'),
 (58,109,72,'not supported','comment'),
 (59,109,71,'yes','comment'),
 (60,110,68,'no','comment'),
 (61,110,66,'conditional pass - provide explanation in adjacent cell','comment'),
 (62,110,64,'not supported','comment'),
 (63,110,65,'yes','comment'),
 (64,110,56,'yes','comment'),
 (65,110,67,'yes','comment'),
 (66,110,73,'yes','comment'),
 (67,110,74,'no','comment'),
 (68,110,72,'yes','comment'),
 (69,110,71,'yes',''),
 (70,111,68,'yes',''),
 (71,111,66,'yes',''),
 (72,111,64,'yes',''),
 (73,111,65,'yes',''),
 (74,111,56,'yes',''),
 (75,111,67,'yes',''),
 (76,111,73,'yes',''),
 (77,111,74,'yes',''),
 (78,111,72,'yes',''),
 (79,111,71,'yes',''),
 (80,112,68,'yes',''),
 (81,112,66,'yes',''),
 (82,112,64,'yes',''),
 (83,112,65,'yes',''),
 (84,112,56,'yes',''),
 (85,112,67,'yes',''),
 (86,112,73,'yes',''),
 (87,112,74,'yes',''),
 (88,112,72,'yes',''),
 (89,112,71,'yes','');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;


--
-- Definition of table `testcase`
--

DROP TABLE IF EXISTS `testcase`;
CREATE TABLE `testcase` (
  `id` int(10) unsigned NOT NULL,
  `descriptionsteps` text NOT NULL,
  `testcasename` varchar(200) NOT NULL,
  `orderworkflow` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testcase`
--

/*!40000 ALTER TABLE `testcase` DISABLE KEYS */;
INSERT INTO `testcase` (`id`,`descriptionsteps`,`testcasename`,`orderworkflow`) VALUES 
 (56,'<font face=\"Arial, Verdana\" size=\"2\">The Google Maps initial location should default to the user\'s locale.</font><div><font face=\"Arial, Verdana\" size=\"2\"><br/></font></div><div><font face=\"Arial, Verdana\" size=\"2\"></font><div>1. Turn off \"Use wireless networks\" and \"Use GPS satellites\" in Settings -&gt; Location &amp;Security settings.</div><div><br/></div><div>2. Launch Maps as if you were a new user launching the application for the first time.</div><div>The Maps default location should be based on the user\'s locale. For example, forlocale=ja&nbsp;(Japan), Maps should open with Japan in view.</div><div><br/></div></div>','Teste 56',5),
 (64,'<div><br/></div><div><br/></div>Verify that the \"Use wireless networks\" consent screen is properly configured.&nbsp;<img src=\"..\\images\\64.png\"/>','Teste 64',3),
 (65,'<font face=\"Arial, Verdana\" size=\"2\">Verify that the \"Use My Location\" consent screen is properly configured.</font><div><img src=\"..\\images\\65.png\"/></div>','Teste 65',4),
 (66,'<div>1 - Is the Network Location Service turned off by default?</div><div>2 - Ensure Network Location Service turned off</div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; \"><br/></div>','Teste 66',2),
 (67,'<div><strong>Objective: </strong>Launching certain applications should result in the appropriate screenshots&nbsp;<span style=\"font-size: 10pt; \">shown below (assuming you are not already signed in to a Google account).</span></div><div><span style=\"font-size: 10pt; \"><br/></span></div><div>One way for the execute the test:</div><div><span style=\"font-size: 10pt; \"></span><div><br/></div><div>Google Market, Gmail, and Google Talk</div><div>1. Sign out of your Google account.</div><div>2. Launch each of the following applications from the</div><div>application tray. In each case, the Google Account setup</div><div>screen shown to the right should appear.</div><div><ul><li><span style=\"font-size: 10pt; \">Android Market</span></li><li><span style=\"font-size: 10pt; \">Gmail</span></li><li><span style=\"font-size: 10pt; \">Talk</span></li></ul></div><div>Press \'Next\' and verify that you can follow the</div><div>Google Account setup sequence to its end.</div><div><br/></div><div><img src=\"..\\images\\67.png\"/></div></div>','Teste 67',6),
 (68,'Is Google Setup Wizard Shown on first Boot?','Teste 68',1),
 (71,'<div><font face=\"Arial, Verdana\" size=\"2\"><strong>Objective: </strong>Verify that a voice-launched search yields accurate results.</font></div><div style=\"font-weight: normal; \"><font face=\"Arial, Verdana\" size=\"2\"><br/></font></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; \">1. Click the microphone icon next to the Google Search box. The \'Speak now\' window&nbsp;<span style=\"font-size: 10pt; \">appears, as shown below.</span></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; \"><span style=\"font-size: 10pt; \"><br/></span></div><div style=\"text-align: center; font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; font-weight: normal; line-height: normal; \"><img src=\"..\\images\\71.png\"/></div>','Teste 71',10),
 (72,'<div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; \"><strong>Objective: </strong>Verify that microphone accurately transcribes content.</div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><br/></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \">1. Click on Messaging in the application tray.</div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \">2. Enter a contact number.</div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \">3. In the body of the message, click on the microphone on keyboard (see the screenshot&nbsp;<span style=\"font-size: 10pt; \">below).</span></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><span style=\"font-size: 10pt; \"><br/></span></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><img src=\"..\\images\\72_1.png\"/></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><br/></div><div><font face=\"Arial, Verdana\" size=\"2\">4. Speak \"flowers\" into the device\'s microphone (see the screenshot below).</font></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><br/></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><img src=\"..\\images\\72_2.png\"/></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \"><br/></div><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \">5.&nbsp;The word \"flowers\" should be transcribed into the message body.</div>','Teste 72',9),
 (73,'<div><strong>Objective: </strong>Verify that you can upload a video to YouTube.</div><div style=\"font-weight: normal; \"><br/></div><div style=\"font-weight: normal; \">1. Open YouTube.</div><div style=\"font-weight: normal; \">2. Click on the \"Camcorder icon\" in the upper right of the screen.</div><div style=\"font-weight: normal; \">3. Take a short video and upload it to YouTube.</div><div style=\"font-weight: normal; \">For Korea, YouTube uploads are disabled. When trying the above steps, the user should see a&nbsp;<span style=\"font-size: 10pt; \">message indicating \"Uploads to YouTube are disabled for your locale,\" as shown in the&nbsp;</span><span style=\"font-size: 10pt; \">screenshot below.</span></div>','Teste 73',7),
 (74,'<b style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; \">Objective:&nbsp;</b><span style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; font-weight: normal; \">Youtube pull the correct content for the locale.</span><div style=\"font-family: Arial, Verdana; font-size: 10pt; font-style: normal; font-variant: normal; line-height: normal; \"><span style=\"font-weight: normal; \"><br/></span></div><div><div><font face=\"Arial, Verdana\" size=\"2\">1. Go to youtube application.</font></div><div><font face=\"Arial, Verdana\" size=\"2\">2. Verify if the videos were in accordance the locale</font></div><div><font face=\"Arial, Verdana\" size=\"2\"><span class=\"Apple-tab-span\" style=\"white-space:pre\">	</span>e.g.: &nbsp;Brazilian Locale will have to show the videos for this locale in portuguese.</font></div></div>','Teste 74',8);
/*!40000 ALTER TABLE `testcase` ENABLE KEYS */;


--
-- Definition of table `testcasesetup`
--

DROP TABLE IF EXISTS `testcasesetup`;
CREATE TABLE `testcasesetup` (
  `id` int(11) NOT NULL DEFAULT '0',
  `note` text NOT NULL,
  `descriptionsetup` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `testcasesetup`
--

/*!40000 ALTER TABLE `testcasesetup` DISABLE KEYS */;
INSERT INTO `testcasesetup` (`id`,`note`,`descriptionsetup`) VALUES 
 (56,'note','description'),
 (64,'note','description'),
 (65,'note','description'),
 (66,'note','description'),
 (67,'note','description'),
 (71,'note','description'),
 (72,'note','description'),
 (73,'note','description'),
 (74,'note','description');
/*!40000 ALTER TABLE `testcasesetup` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`login`,`password`,`type`) VALUES 
 (1,'admin','admin','adm');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
