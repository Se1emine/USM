const { Student } = require("../database/student");

module.exports = async () => {
  const students = await Student.findAll();
  if (students.length > 0) {
    const restructured = students.map((item) => ({
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

    console.table(
      restructured.sort(
        (a, b) => a["Group"].split(" ")[1] - b["Group"].split(" ")[1]
      )
    );
  } else {
    console.log("Not found students.");
  }
};
