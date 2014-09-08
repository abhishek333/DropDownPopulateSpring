INSERT IGNORE INTO `country`(`name`) VALUES('India'),('Pakistan'),('Bangladesh');

SELECT id INTO @indiaId FROM country WHERE name = 'India';

INSERT IGNORE INTO `state`(`name`,`country_id`) VALUES('Odisha',@indiaId),('Karnataka',@indiaId),('Mumbai',@indiaId);

--SELECT @pakId:=id FROM country WHERE name = 'Pakistan';
SELECT id INTO @pakId FROM country WHERE name = 'Pakistan';

INSERT IGNORE INTO `state`(`name`,`country_id`) VALUES('Sindh',@pakId),('Khyber Pakhtunkawa',@pakId),('Punjab',@pakId);

--SELECT @bangId:=id FROM country WHERE name = 'Bangladesh';
SELECT id INTO @bangId FROM country WHERE name = 'Bangladesh';

INSERT IGNORE INTO `state`(`name`,`country_id`) VALUES('Barisal',@bangId),('Chittagong',@bangId),('Dhaka ',@bangId);