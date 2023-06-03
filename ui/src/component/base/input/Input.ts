interface IInput {
  type: string;
  placeholder?: string;
  id?: string;
  name?: string;
  defaultValue?: any;
  icon?: string;
  label?: string;
  onChange?: (event: any) => void;
  required?: any;
}
export default IInput;
