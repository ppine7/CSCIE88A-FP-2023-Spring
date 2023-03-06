package com.cscie88a.week7

object School {
  
  final case class Student(
      id: String,
      fistName: String,
      lastName: String,
      email: String,
      gender: String,
      country: String
  )

  final case class Subject(
      id: String,
      name: String
  )

  final case class Enrollment(
      studentId: String,
      subjectId: String
  )

  val studentList: List[Student] = ???

  val subjectList: List[Subject] = ???

  val enrollmentList: List[Enrollment] = ???

  def studentBySubjectRows(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): List[(Subject, Student)] = ???

  def studentsBySubject(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): Map[Subject, List[Student]] = ???

  def classSizeBySubject(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): Map[Subject, Int] = ???

}