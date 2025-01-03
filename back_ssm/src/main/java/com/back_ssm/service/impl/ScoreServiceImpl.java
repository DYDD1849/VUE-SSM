package com.back_ssm.service.impl;

import com.back_ssm.mapper.ScoreMapper;
import com.back_ssm.pojo.Score;
import com.back_ssm.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public int addScore(Score score) {
        return scoreMapper.addScore(score);
    }

    @Override
    public int delScore(Score score) {
        return scoreMapper.delScore(score);
    }

    @Override
    public int altScore(Score score) {
        return scoreMapper.altScore(score);
    }
}
