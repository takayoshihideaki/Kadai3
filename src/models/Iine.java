package models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "iine")
@NamedQueries({

    @NamedQuery(
            name = "getIineCount",
            query = "SELECT COUNT(distinct i.employee) from Iine i where i.report.id = :id"
            ),
    @NamedQuery(
            name = "getIineCount2",
            query = "SELECT COUNT(i) from Iine i where i.employee.id = :idd and i.report.id = :id"
            ),
    @NamedQuery(
            name = "IineDelete",
            query = "SELECT i from Iine i where i.employee.id = :idd and i.report.id = :id"
            )


})


@Entity
public class Iine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }




}