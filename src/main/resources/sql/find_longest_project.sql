SELECT ID,
       EXTRACT(MONTH FROM FINISH_DATE) - EXTRACT(MONTH FROM START_DATE) AS duration
FROM PROJECT;
