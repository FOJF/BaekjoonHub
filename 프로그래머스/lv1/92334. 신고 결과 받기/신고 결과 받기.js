function solution(id_list, report, k) {
    let answer = new Array(id_list.length).fill(0);
    let reportedCnts = new Array(id_list.length).fill(0);
    let pauseIds = [];
    
    
    // 신고의 중복 제거
    const set = new Set(report);
    const deduplicationReport = [...set];
    
    // 신고 당한 횟수 파악
    deduplicationReport.forEach((r) => {
        const strs = r.split(` `);
        const index = id_list.indexOf(strs[1]);
        reportedCnts[index]++;
    });
    
    // 정지된 유저 파악
    for (let i = 0; i < reportedCnts.length; i++) {
        if (reportedCnts[i] >= k) pauseIds.push(id_list[i]);
    }
    
    // 처리 결과 메일을 받은 횟수 파악
    deduplicationReport.forEach((r) => {
        const strs = r.split(` `);
        const index = id_list.indexOf(strs[0]);
        
        if (pauseIds.includes(strs[1])) answer[index]++;
    });
    
    return answer;
}