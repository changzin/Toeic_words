package demo.ToeicWord.word.repository;

import demo.ToeicWord.word.domain.Word;
import org.hibernate.sql.exec.spi.JdbcInsert;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Primary
public class JdbcTemplateWordRepository implements WordRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateWordRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Word save(Word word) {
        SimpleJdbcInsert jdbcInsert= new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("WORD").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("spell", word.getSpell());
        parameters.put("mean", word.getMean());
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        word.setId(key.longValue());
        return word;
    }

    @Override
    public Optional<Word> findById(Long id) {
        List<Word> list = jdbcTemplate.query(
                "select * from WORD where id = ?",
                new RowMapper<Word>() {
                    @Override
                    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Word word = new Word(
                                rs.getString("spell"),
                                rs.getString("mean"));
                        word.setId(rs.getLong("id"));
                        return word;
                    }
                },
        id);
        return Optional.ofNullable(list.get(0));
    }

    @Override
    public List<Word> selectAllWords() {
        List<Word> list = jdbcTemplate.query(
                "select * from WORD",
                new RowMapper<Word>() {
                    @Override
                    public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Word word = new Word(
                                rs.getString("spell"),
                                rs.getString("mean"));
                        word.setId(rs.getLong("id"));
                        return word;
                    }
                }
        );
        return list.isEmpty() ? null : list;
    }
}
