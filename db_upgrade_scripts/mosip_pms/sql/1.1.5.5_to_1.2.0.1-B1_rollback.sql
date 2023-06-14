\c mosip_pms

DROP TABLE IF EXISTS pms.device_detail;
DROP TABLE IF EXISTS pms.device_detail_sbi;
DROP TABLE IF EXISTS pms.ftp_chip_detail;
DROP TABLE IF EXISTS pms.reg_device_sub_type;
DROP TABLE IF EXISTS pms.reg_device_type;
DROP TABLE IF EXISTS pms.secure_biometric_interface;
DROP TABLE IF EXISTS pms.secure_biometric_interface_h;

ALTER TABLE pms.partner_policy DROP COLUMN label;
ALTER TABLE pms.partner DROP COLUMN lang_code;
ALTER TABLE pms.partner_h DROP COLUMN lang_code;
