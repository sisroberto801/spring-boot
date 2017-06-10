package com.dh.demo.web;

import com.dh.demo.domain.Subscription;
import com.dh.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author rOlguin
 */
@RequestMapping("/subscriptions")
@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.getAllSubscriptions();
    }
    @RequestMapping(method = RequestMethod.POST)
    public void addSubscription(@RequestBody SubscritionRequestDTO subscription){
        subscriptionService.addNewSubscription(subscription);
    }

    // DTO

    public static class SubscritionRequestDTO{

        private String teacherId;
        private String studentId;

        private String roomId;
        private String subjectId;

        private Date subDate;

        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public void setSubDate(Date subDate) {
            this.subDate = subDate;
        }
        public String getTeacherId() {
            return teacherId;
        }

        public String getStudentId() {
            return studentId;
        }

        public Date getSubDate() {
            return subDate;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }
    }
}