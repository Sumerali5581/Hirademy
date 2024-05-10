package com.example.hirademy.Controller;

import com.example.hirademy.Model.Assistant;
import com.example.hirademy.Service.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AssistantController {

    @Autowired
    private AssistantService assistantService;

    @GetMapping("/assistant")
    public ResponseEntity<List<Assistant>> getAllAssistants()
    {
        List<Assistant> assistants= assistantService.getAllAssistants();
        return new ResponseEntity<>(assistants, HttpStatus.OK);
    }

    @GetMapping("/assistant/{assistant_id}")
    public ResponseEntity<Assistant> getAssistantById(@PathVariable("assistant_id") Long id)
    {
        Optional<Assistant> assistant= assistantService.getAssistantById(id);
        return assistant.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/assistant")
    public ResponseEntity<Long> createAssistant(@RequestBody Assistant assistant)
    {
        Assistant assistant1 = assistantService.createAssistant(assistant);
        return new ResponseEntity<>(assistant1.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/assistant/{assistant_id}")
    public ResponseEntity<Assistant> updateAssistant(@PathVariable("assistant_id") Long id, @RequestBody Assistant assistant)
    {
        Assistant updateAssistant = assistantService.updateAssistant(id,assistant);
        return updateAssistant != null ?
                new ResponseEntity<>(updateAssistant,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/assistant/{assistant_id}")
    public ResponseEntity<Void> deleteAssistant(@PathVariable("assistant_id") Long id)
    {
        assistantService.deleteAssistant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
