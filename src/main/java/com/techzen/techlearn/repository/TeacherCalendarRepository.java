package com.techzen.techlearn.repository;

import com.techzen.techlearn.entity.TeacherCalendarEntity;
import com.techzen.techlearn.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface TeacherCalendarRepository extends JpaRepository<TeacherCalendarEntity, Integer> {

    boolean existsByTeacherAndDateAppointmentAndTimeStartAndTimeEnd(TeacherEntity teacher, LocalDate dateAppointment,LocalTime timeStart, LocalTime timeEnd);

    @Query("SELECT tc " +
            "FROM TeacherCalendarEntity tc " +
            "JOIN tc.teacher t " +
            "JOIN TechnicalEntity te ON te.teacherEntity.id = t.id " +
            "WHERE te.name = :technicalName " +
            "AND t.name = :teacherName " +
            "AND tc.dateAppointment >= CURRENT_DATE " +
            "AND tc.status = 'Booked'")
    List<TeacherCalendarEntity> findAppointmentsByTechnicalAndTeacher(
            @Param("technicalName") String technicalName,
            @Param("teacherName") String teacherName);


}
