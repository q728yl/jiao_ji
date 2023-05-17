//package com.example.jiaoji_app_back.repository;
//
//import com.example.jiaoji_app_back.entity.ActivityDetails;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.List;
//@Repository
//public class ActivityDetailsRepositoryImpl implements ActivityDetailsRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public ActivityDetailsRepositoryImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<ActivityDetails> findAllActivity() {
//        String sql = "SELECT * FROM activity_details";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            String signupRestrictionJson = rs.getString("signupRestriction");
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode signupRestrictionNode = null;
//            try {
//                signupRestrictionNode = objectMapper.readTree(signupRestrictionJson);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//            JsonNode collegeNode = signupRestrictionNode.get("College");
//            String college = collegeNode.isArray() && collegeNode.size() > 0 ? collegeNode.get(0).asText() : null;
//            JsonNode gradeNode = signupRestrictionNode.get("Grade");
//            String grade = gradeNode.isArray() && gradeNode.size() > 0 ? gradeNode.get(0).asText() : null;
//            JsonNode clubNode = signupRestrictionNode.get("Club");
//            String club = clubNode.isArray() && clubNode.size() > 0 ? clubNode.get(0).asText() : null;
//            return new ActivityDetails(
//                    rs.getLong("id"),
//                    rs.getString("name"),
//                    rs.getString("content"),
//                    rs.getString("location"),
//                    rs.getString("signupTime"),
//                    rs.getString("activityTime"),
//                    rs.getString("departments"),
//                    rs.getString("signupRestriction"),
//                    college,
//                    grade,
//                    club,
//                    rs.getLong("recruitmentNumber"),
//                    rs.getLong("remainingNumber"),
//                    rs.getString("organizer"),
//                    rs.getLong("suScore"),
//                    rs.getLong("laborHour"),
//                    rs.getString("status"),
//                    rs.getString("comments")
//            );
//        });
//
//    }
//
//    @Override
//    public List<ActivityDetails> findPassedActivity() {
//        String sql = "SELECT * FROM activity_details where status = 1";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            String signupRestrictionJson = rs.getString("signupRestriction");
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode signupRestrictionNode = null;
//            try {
//                signupRestrictionNode = objectMapper.readTree(signupRestrictionJson);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//            JsonNode collegeNode = signupRestrictionNode.get("College");
//            String college = collegeNode.isArray() && collegeNode.size() > 0 ? collegeNode.get(0).asText() : null;
//            JsonNode gradeNode = signupRestrictionNode.get("Grade");
//            String grade = gradeNode.isArray() && gradeNode.size() > 0 ? gradeNode.get(0).asText() : null;
//            JsonNode clubNode = signupRestrictionNode.get("Club");
//            String club = clubNode.isArray() && clubNode.size() > 0 ? clubNode.get(0).asText() : null;
//            return new ActivityDetails(
//                    rs.getLong("id"),
//                    rs.getString("name"),
//                    rs.getString("content"),
//                    rs.getString("location"),
//                    rs.getString("signupTime"),
//                    rs.getString("activityTime"),
//                    rs.getString("departments"),
//                    rs.getString("signupRestriction"),
//                    college,
//                    grade,
//                    club,
//                    rs.getLong("recruitmentNumber"),
//                    rs.getLong("remainingNumber"),
//                    rs.getString("organizer"),
//                    rs.getLong("suScore"),
//                    rs.getLong("laborHour"),
//                    rs.getString("status"),
//                    rs.getString("comments")
//            );
//        });
//
//    }
//
//    @Override
//    public ActivityDetails changeStatus(Long id, String status, String comments) {
//        String sql = "UPDATE activity_details SET status = ?, comments = ? WHERE id = ?";
//        int count = jdbcTemplate.update(sql, status, comments, id);
//        if (count == 1) {
//            sql = "SELECT * FROM activity_details WHERE id = ?";
//            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//                String signupRestrictionJson = rs.getString("signupRestriction");
//                ObjectMapper objectMapper = new ObjectMapper();
//                JsonNode signupRestrictionNode = null;
//                try {
//                    signupRestrictionNode = objectMapper.readTree(signupRestrictionJson);
//                } catch (JsonProcessingException e) {
//                    throw new RuntimeException(e);
//                }
//                JsonNode collegeNode = signupRestrictionNode.get("College");
//                String college = collegeNode.isArray() && collegeNode.size() > 0 ? collegeNode.get(0).asText() : null;
//                JsonNode gradeNode = signupRestrictionNode.get("Grade");
//                String grade = gradeNode.isArray() && gradeNode.size() > 0 ? gradeNode.get(0).asText() : null;
//                JsonNode clubNode = signupRestrictionNode.get("Club");
//                String club = clubNode.isArray() && clubNode.size() > 0 ? clubNode.get(0).asText() : null;
//
//                return new ActivityDetails(
//                        rs.getLong("id"),
//                        rs.getString("name"),
//                        rs.getString("content"),
//                        rs.getString("location"),
//                        rs.getString("signupTime"),
//                        rs.getString("activityTime"),
//                        rs.getString("departments"),
//                        rs.getString("signupRestriction"),
//                        college,
//                        grade,
//                        club,
//                        rs.getLong("recruitmentNumber"),
//                        rs.getLong("remainingNumber"),
//                        rs.getString("organizer"),
//                        rs.getLong("suScore"),
//                        rs.getLong("laborHour"),
//                        rs.getString("status"),
//                        rs.getString("comments")
//                );
//            });
//        }
//        return null;
//    }
//
//    @Override
//    public ActivityDetails handleSignup(Long userId, Long activityId){
//        return null;
//    }
//    @Override
//    public ActivityDetails getPassedActivityById(Long activityId) {
//        String sql = "SELECT * FROM activity_details WHERE id = ? AND status = 'pass'";
//        return jdbcTemplate.queryForObject(sql, new Object[]{activityId}, (rs, rowNum) -> {
//            String signupRestrictionJson = rs.getString("signupRestriction");
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode signupRestrictionNode = null;
//            try {
//                signupRestrictionNode = objectMapper.readTree(signupRestrictionJson);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//            JsonNode collegeNode = signupRestrictionNode.get("College");
//            String college = collegeNode != null && collegeNode.isArray() && collegeNode.size() > 0 ? collegeNode.get(0).asText() : null;
//            JsonNode gradeNode = signupRestrictionNode.get("Grade");
//            String grade = gradeNode != null && gradeNode.isArray() && gradeNode.size() > 0 ? gradeNode.get(0).asText() : null;
//            JsonNode clubNode = signupRestrictionNode.get("Club");
//            String club = clubNode != null && clubNode.isArray() && clubNode.size() > 0 ? clubNode.get(0).asText() : null;
//            return new ActivityDetails(
//                    rs.getLong("id"),
//                    rs.getString("name"),
//                    rs.getString("content"),
//                    rs.getString("location"),
//                    rs.getString("signupTime"),
//                    rs.getString("activityTime"),
//                    rs.getString("departments"),
//                    rs.getString("signupRestriction"),
//                    college,
//                    grade,
//                    club,
//                    rs.getLong("recruitmentNumber"),
//                    rs.getLong("remainingNumber"),
//                    rs.getString("organizer"),
//                    rs.getLong("suScore"),
//                    rs.getLong("laborHour"),
//                    rs.getString("status"),
//                    rs.getString("comments")
//            );
//        });
//    }
//    @Override
//    public void updateActivityRemainingNumber(Long activityId,Long remainingNumber) {
//        String sql = "UPDATE activity_details SET remainingNumber = ? WHERE id = ?";
//        jdbcTemplate.update(sql, remainingNumber,activityId);
//
//    }
//};
//
