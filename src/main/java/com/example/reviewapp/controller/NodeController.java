package com.example.reviewapp.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.example.reviewapp.dto.NodeForm;

import com.example.reviewapp.entity.Node;
import com.example.reviewapp.service.NodeService;

@Controller
@RequestMapping("/nodes")
public class NodeController{

    //メンバ変数
    private final NodeService nodeService;
    
    //コンストラクタ
    public NodeController(NodeService nodeService){
        this.nodeService = nodeService;
    }

    //一覧を表示するメソッド
    @GetMapping
    public String findAll(Model model){
        List<Node> nodes = nodeService.findAll();
        model.addAttribute("nodes", nodes);
        return "nodes/list";
    }

    //新規画面を表示するメソッド
    @GetMapping("/new")
    public String newForm(Model model){
        model.addAttribute("nodeForm",new NodeForm());
        return "nodes/new";
    }

    //新規登録するメソッド
    //バリデーション（入力時空白の場合エラー表示）
    @PostMapping
    public String create(@Valid NodeForm nodeForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "nodes/new";
        }

        nodeService.create(nodeForm.getTitle(), nodeForm.getContent());
        return "redirect:/nodes";
    }

    //編集画面を表示するメソッド
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model){
        Node node = nodeService.findById(id);

        NodeForm nodeForm = new NodeForm();
        nodeForm.setTitle(node.getTitle());
        nodeForm.setContent(node.getContent());

        model.addAttribute("nodeForm", nodeForm);
        model.addAttribute("nodeId",id);

        return "nodes/edit";
    }

    //編集するメソッド
    @PostMapping("/{id}")
    public String update(
            @PathVariable Long id, 
            @Valid NodeForm nodeForm,
            BindingResult bindingResult,
            Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("nodeId" ,id);
            return "nodes/edit";
        }

        nodeService.update(id, nodeForm.getTitle(), nodeForm.getContent());
        return "redirect:/nodes";
    }

    //削除するメソッド
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        nodeService.delete(id);
        return "redirect:/nodes";
}


}