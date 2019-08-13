-- !Ups

CREATE TABLE "orders" (
    "id" INT PRIMARY KEY,
    "drink" VARCHAR(30) NOT NULL,
    "price" DOUBLE NOT NULL
);

INSERT INTO "orders" VALUES (1, 'Tea', 1.00), (2, 'Coffee', 1.20);

-- !Downs

DROP TABLE "orders";