DROP TABLE if exists PROPERTIES;

CREATE TABLE properties (
  id bigint(20) AUTO_INCREMENT PRIMARY KEY,
  description varchar(10000) NOT NULL,
  listing_type int(11) NOT NULL,
  location varchar(255) NOT NULL,
  number_of_bedrooms int(11) NOT NULL,
  price bigint(20) NOT NULL,
  property_type int(11) NOT NULL,
  url varchar(255) NOT NULL
) ;