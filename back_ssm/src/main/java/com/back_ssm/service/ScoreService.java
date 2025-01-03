package com.back_ssm.service;

import com.back_ssm.pojo.Score;

public interface ScoreService {
    public int addScore(Score score);
    public int delScore(Score score);
    public int altScore(Score score);
}
