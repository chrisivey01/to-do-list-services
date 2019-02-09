package com.list.todolist.controller;


        import com.list.todolist.SMS;
        import com.list.todolist.entity.ToDoList;
        import com.list.todolist.repository.ListRepo;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.web.bind.annotation.*;

        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.Optional;

        import com.twilio.Twilio;


@CrossOrigin
@RestController
@Transactional

public class ListController {

    private ListRepo listRepo;

    @Autowired
    public ListController(ListRepo listRepo){
        this.listRepo = listRepo;
    }

    @PostMapping("/item")
    public ToDoList createItem(@RequestBody ToDoList toDoListItem){
        return listRepo.save(toDoListItem);
    }

    @GetMapping("/items")
    public List<ToDoList> getList(){
        List<ToDoList> list = listRepo.findAll();
        if(list.size() <= 0){
            ToDoList obj = new ToDoList();
            obj.setItem("List completed!");
            list.add(obj);
        }
        return list;
    }

    @GetMapping("items/{id}")
    public Optional<ToDoList> getItemById(@PathVariable Integer id){
        return listRepo.findById(id);
    }

    @DeleteMapping("items/delete/")
    public String deleteItemById(@RequestBody String item){
        listRepo.deleteByItem(item);

        List<ToDoList> list = listRepo.findAll();
        if(list.size() == 0){
            return "List completed!";
        }
        return "Item removed successfully!";
    }

    @GetMapping("/text")
    public String sendText(){
        SMS sms = new SMS();
        sms.main(null);

        return "Text sent!";
    }

    @Scheduled(cron = "0 */12 * * *")
    public void cron(){
        sendText();
    }
}
