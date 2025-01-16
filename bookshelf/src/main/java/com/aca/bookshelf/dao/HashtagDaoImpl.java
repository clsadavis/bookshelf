package com.aca.bookshelf.dao;

import com.aca.bookshelf.model.Book;
import com.aca.bookshelf.model.Hashtag;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HashtagDaoImpl implements HashtagDao {

    private static String selectAllHashtags =
            "SELECT hashtagName \n" +
                    "FROM hashtags";

    private static String selectHashtagsById =
            "SELECT hashtagName " +
                    "FROM hashtags " +
                    "WHERE hashtagId = ? ";

    private static String updateHashtagById =
            "UPDATE hashtags" +
                    "SET hashtagName = ?, " +
                    "description = ? ";



    @Override
    public List<Hashtag> getHashtags() {
        List<Hashtag> myHashtags = new ArrayList<>();
        ResultSet result = null;
        Statement statement = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(selectAllHashtags);
            myHashtags = makeHashtags(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myHashtags;
    }

    private List<Hashtag> makeHashtags(ResultSet result) throws SQLException {
        List<Hashtag> hashtags = new ArrayList<>();

        while(result.next()){
            Hashtag hashtag = new Hashtag();
            hashtag.setHashtagName(result.getString("hashtagName"));

            hashtags.add(hashtag);
        }
        return hashtags;
    }

    @Override
    public List<Hashtag> getHashtagsById(Integer hashtagId) {
        List<Hashtag> myHashtags = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDbUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectHashtagsById);
            ps.setInt(1,hashtagId);
            result = ps.executeQuery();
            myHashtags = makeHashtags(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myHashtags;
    }

    @Override
    public Hashtag updateHashtag(Hashtag updateHashtag){
        List<Hashtag> hashtags = this.getHashtagsById(updateHashtag.getHashtagId());

        if(hashtags.size() > 0 ){
            PreparedStatement ps = null;
            Connection connection = MariaDbUtil.getConnection();
            try {
                ps = connection.prepareStatement(updateHashtagById);
                ps.setString(1, updateHashtag.getHashtagName());
                ps.setString(2, updateHashtag.getDescription());
                int rowCount = ps.executeUpdate();
                System.out.println("Rows updated: " + rowCount);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateHashtag;
    }
}
