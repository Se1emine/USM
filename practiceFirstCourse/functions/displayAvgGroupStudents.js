const { Student } = require("../database/student");

module.exports = async () => {
  const students = await Student.findAll();
  const filtered = students.filter(
    (item) =>
      item.dataValues.grades
        .split(",")
        .map(Number)
        .reduce((a, b) => a + b, 0) /
        item.dataValues.grades.split(",").length >
      4
  );

  if (filtered.length > 0) {
    const restructured = filtered.map((item) => ({
      "Last Name": item.dataValues.lastName,
      "First Name": item.dataValues.firstName,
      Group: item.dataValues.group,
      "Avg Grade":
        item.dataValues.grades
          .split(",")
          .map(Number)
          .reduce((a, b) => a + b, 0) /
        item.dataValues.grades.split(",").length,
    }));

    console.table(restructured);
  } else {
    console.log("Not found students.");
  }
};
