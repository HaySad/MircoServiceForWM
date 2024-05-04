# รายละเอียด

**ข้อมูล**

<i>kafkaProducerScan</i> and <i>kafkaConsumerScan</i>

เป็น Service ของการสแกนข้อมูลจาก Barcode เข้าสู่ระบบและส่งไปให้กับ Consumer

<i>microservices1</i> 

เป็น Service ที่เป็น DataController ที่ดึงข้อมูลรถที่จะนำเข้ามาเพื่อส่งไปยัง <i>KafkaConsumer2</i> โดยตัวมันนั้นจะรับข้ความ pack ของมูลเป็น repo แล้วสะกัดนำข้อมูลไปค้นใน ฐานข้อมูลของสิ่นค้า

**Database**

ใช้เป็น Docker โดยเป็นคอแทนเนอร์ของ `mcr.microsoft.com/mssql/server:2022-latest`

Update 4/4

**diagram_final**

เป็นตัว BPMN ที่มีทั้งไฟล์ SVG และ BPMN

**Robot**

คือ Service ที่ทำหน้าที่สั่งการส่งคำสั่งและค้นหาพื้นที่ว่าในคลังสินค้าที่อยู่ใน Database

Update 4/5 Time : 21:46




