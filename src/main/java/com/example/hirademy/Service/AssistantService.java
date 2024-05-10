package com.example.hirademy.Service;

import com.example.hirademy.Model.Assistant;
import com.example.hirademy.Repository.AssistantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistantService {

    @Autowired
    private AssistantRepository assistantRepository;

    public List<Assistant> getAllAssistants()
    {
        return assistantRepository.findAll();
    }

    public Optional<Assistant> getAssistantById(Long id)
    {
        return assistantRepository.findById(id);
    }

    public Assistant createAssistant(Assistant assistant)
    {
        return assistantRepository.save(assistant);
    }

    public Assistant updateAssistant(Long id,Assistant assistant)
    {
        if(assistantRepository.existsById(id))
        {
            assistant.setId(id);
            return assistantRepository.save(assistant);
        }
        else
        {
            return null;
        }
    }

    public void deleteAssistant(Long id)
    {
        assistantRepository.deleteById(id);
    }
}
