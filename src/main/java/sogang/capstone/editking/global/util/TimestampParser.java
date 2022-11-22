package sogang.capstone.editking.global.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sogang.capstone.editking.global.exception.BadRequestException;

public class TimestampParser {

    public Timestamp stringToTimestamp(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);

        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(time);
        } catch (ParseException e) {
            throw new BadRequestException("날짜 형식이 맞지 않습니다.");
        }

        return new Timestamp(parsedDate.getTime());
    }

}
