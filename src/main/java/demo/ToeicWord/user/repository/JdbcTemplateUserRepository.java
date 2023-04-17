package demo.ToeicWord.user.repository;

import com.mysql.cj.result.Row;
import demo.ToeicWord.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateUserRepository implements UserRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public User save(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert((jdbcTemplate));
        jdbcInsert.withTableName("USER").usingGeneratedKeyColumns("user_id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", user.getUserName());
        parameters.put("password", user.getPassword());
        parameters.put("tier", user.getTier());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return user;
    }

    @Override
    public Optional<User> findbyId(Long id) {
        List<User> list = jdbcTemplate.query(
                "select * from USER where user_id = ?",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(
                                rs.getLong("user_id"),
                                rs.getString("name"),
                                rs.getString("password"),
                                rs.getInt("tier")
                        );
                    }
                },
        id);
        if (list.isEmpty())
            return Optional.empty();
        else
            return Optional.ofNullable(list.get(0));
    }

    @Override
    public List<User> selectALlUsers() {
        List<User> list = jdbcTemplate.query(
                "select * from USER",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User(
                                rs.getLong("user_id"),
                                rs.getString("name"),
                                rs.getString("password"),
                                rs.getInt("tier")
                        );
                        return user;
                    }
                }
        );
        return list.isEmpty() ? null : list;
    }

    @Override
    public Optional<User> updateById(User user) {
        String sql = "update USER set name=?, password=? where user_id =" + user.getUserId();
        int result = jdbcTemplate.update(sql, user.getUserName(), user.getPassword());
        return findbyId(user.getUserId());
    }

    @Override
    public int deleteById(Long id) {
        String sql = "delete from USER where user_id=" + id;
        return jdbcTemplate.update(sql);
    }
}
