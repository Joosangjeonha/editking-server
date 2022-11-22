package sogang.capstone.editking.form.domain;

public interface FormRepository {

    public Form findById(Long id);

    public void save(Form form);

    public void delete(Form form);
}
