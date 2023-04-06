package demo.ToeicWord.word.repository;

import demo.ToeicWord.word.domain.Word;
import org.hibernate.sql.exec.spi.JdbcInsert;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Primary
public class JdbcTemplateWordRepository implements WordRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateWordRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        save(new Word("spell", "mean"));
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
        return Optional.empty();
    }
}
