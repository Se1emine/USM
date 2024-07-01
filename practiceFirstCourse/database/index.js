const { Sequelize } = require("sequelize");

const database = new Sequelize({
  dialect: "sqlite",
  storage: "database.sqlite",
  logging: false,
});

module.exports = { database };
