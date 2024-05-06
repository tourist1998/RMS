package in.krishak.agro.RMS.service;

import in.krishak.agro.RMS.controller.DailyStat;
import in.krishak.agro.RMS.daos.DailyStatRepository;
import in.krishak.agro.RMS.daos.UserRepository;
import in.krishak.agro.RMS.dto.PaginatedResponseDTO;
import in.krishak.agro.RMS.dto.UserDailyRecordDTO;
import in.krishak.agro.RMS.mapper.UserDailyStatRecordMapper;
import in.krishak.agro.RMS.models.DailyRecord;
import in.krishak.agro.RMS.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyStatService {

    @Autowired
    private DailyStatRepository dailyStatRepository;

    @Autowired
    private UserRepository userRepository;

    public void persistDailyStatDetail(String externalId, UserDailyRecordDTO userDailyRecordDTO) {
        Optional<User> user = userRepository.findByExternalId(externalId);

        if(user.isPresent()) {
            userDailyRecordDTO.setUserId(user.get().getId());
            dailyStatRepository.save(UserDailyStatRecordMapper.toEntity(userDailyRecordDTO));

        } else {
            throw new RuntimeException("Invalid userId");
        }
    }

    public PaginatedResponseDTO<DailyRecord> fetchStatDetail(String userExternalId) {
        Optional<User> user = userRepository.findByExternalId(userExternalId);
        if(user.isPresent()) {
            List<DailyRecord> records = dailyStatRepository.findByUserId(user.get().getId().intValue()).get();
            return new PaginatedResponseDTO<DailyRecord>(records, 3, 0, 1);
        } else {
            throw new RuntimeException("Invalid userId");
        }
    }
}
