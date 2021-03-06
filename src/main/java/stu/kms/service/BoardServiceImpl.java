package stu.kms.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import stu.kms.domain.BoardVO;
import stu.kms.domain.Criteria;
import stu.kms.mapper.BoardMapper;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register ... " + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get..." + bno);
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify..." + board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove..." + bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public int getTotal(Criteria criteria) {
        log.info("get total count");
        return mapper.getTotalCount(criteria);
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("getList with Criteria..." + criteria);
        return mapper.getListWithPaging(criteria);
    }
}
