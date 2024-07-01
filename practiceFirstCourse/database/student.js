const { DataTypes } = require("sequelize");
const { database } = require("./index");

const Student = database.define(
  "Student",
  {
    lastName: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        isAlpha: {
          msg: "Last name must contain only letters.",
        },
      },
    },
    firstName: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        isAlpha: {
          msg: "First name must contain only letters.",
        },
      },
    },
    group: {
      type: DataTypes.STRING,
      allowNull: false,
    },
    grades: {
      type: DataTypes.STRING,
      allowNull: false,
      validate: {
        isGradesArray(value) {
          const gradesArray = value.split(",").map(Number);
          if (gradesArray.length !== 5 || gradesArray.some(isNaN)) {
            throw new Error("Grades must be an array of 5 numbers");
          }
        },
      },
    },
  },
  {
    timestamps: false,
  }
);

module.exports = { Student };
