package com.app.threetier.controller;

import com.app.threetier.domain.dto.MemberDTO;
import com.app.threetier.domain.dto.Pagination;
import com.app.threetier.domain.dto.PostDTO;
import com.app.threetier.domain.dto.PostListDTO;
import com.app.threetier.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;
    private final HttpSession session;
    private final MemberDTO memberDTO;

    //    목록
    @GetMapping("/post/list")
    public void goToListForm(){;}

    @GetMapping("/posts/list")
    @ResponseBody
    public PostListDTO getList(Pagination pagination){
        return postService.getList(pagination);
    }

    @GetMapping(value = {"/post/read", "/post/update"})
    public String goToReadForm(Long id, Model model, HttpServletRequest request){
        log.info(request.getRequestURI());
        PostDTO postDTO = postService.read(id);
        model.addAttribute("post", postDTO);
        return request.getRequestURI().equals("/post/read") ? "/post/read" : "/post/update";
    }

    @GetMapping("/post/write")
    public void goToWriteForm(PostDTO postDTO){;}

    @PostMapping("/post/write")
    public RedirectView write(PostDTO postDTO, @RequestParam("file") List<MultipartFile> files){
        postDTO.setMemberId(((MemberDTO)session.getAttribute("member")).getId());
        postService.write(postDTO, files);
        return new RedirectView("/post/list");
    }

    @PostMapping("/post/update")
    public RedirectView update(PostDTO postDTO, @RequestParam(value = "file-id", required = false) Long[] arIdToDelete, @RequestParam("file") List<MultipartFile> files, RedirectAttributes redirectAttributes){
//        쿼리 스트링: 다음 컨트롤러에서 사용할 때
        redirectAttributes.addAttribute("id", postDTO.getId());
//        세션: 화면에서 사용할 때
//        redirectAttributes.addFlashAttribute();

        postService.update(postDTO, arIdToDelete, files);
        return new RedirectView("/post/read");
    }

    @GetMapping("/post/delete")
    public RedirectView delete(Long id){
        postService.delete(id);
        return new RedirectView("/post/list");
    }
}
















