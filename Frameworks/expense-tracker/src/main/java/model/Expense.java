package model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "expense")
public class Expense  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expense_id")
    private int id;
    private String title;
    private  String date;
    private  String time;
    private  String description;
    private  int price;

    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;


}
