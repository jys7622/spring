package com.jys7622.myapp.mapper;


import java.util.List;

import com.jys7622.myapp.VO.PostVO;

public interface PostMapper {

    PostVO getPost(String postId);


    int writeProcess(PostVO postVO);

    int deleteProcess(String id);

    int updateProcess(PostVO postVO);

	List<PostVO> getSearch();

}
