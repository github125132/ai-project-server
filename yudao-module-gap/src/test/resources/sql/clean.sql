-- 清理 GAP 模块的表数据
SET FOREIGN_KEY_CHECKS = 0;

-- Module 13: 审计日志
TRUNCATE TABLE gap_data_review;
TRUNCATE TABLE gap_data_change_log;
TRUNCATE TABLE gap_operation_log;

-- Module 12: 溯源管理
TRUNCATE TABLE gap_trace_node;
TRUNCATE TABLE gap_trace_batch;

-- Module 11: 变更投诉召回
TRUNCATE TABLE gap_recall_record;
TRUNCATE TABLE gap_complaint;
TRUNCATE TABLE gap_change_record;

-- Module 10: 内部审核管理
TRUNCATE TABLE gap_nc_item;
TRUNCATE TABLE gap_audit_checklist_item;
TRUNCATE TABLE gap_audit_checklist;
TRUNCATE TABLE gap_audit_plan;

-- Module 9: 培训管理
TRUNCATE TABLE gap_person_health;
TRUNCATE TABLE gap_training_participant;
TRUNCATE TABLE gap_training_record;
TRUNCATE TABLE gap_training_plan;
TRUNCATE TABLE gap_training_course;

-- Module 8: 文件体系管理
TRUNCATE TABLE gap_record_template;
TRUNCATE TABLE gap_sop;
TRUNCATE TABLE gap_document;
TRUNCATE TABLE gap_document_category;

-- Module 7: 质量检测管理
TRUNCATE TABLE gap_release_record;
TRUNCATE TABLE gap_sample_record;
TRUNCATE TABLE gap_heavy_metal;
TRUNCATE TABLE gap_pesticide_residue;
TRUNCATE TABLE gap_inspect_report;
TRUNCATE TABLE gap_inspect_record;
TRUNCATE TABLE gap_inspect_task;
TRUNCATE TABLE gap_quality_standard;

-- Module 6: 仓储物流管理
TRUNCATE TABLE gap_unqualified_handle;
TRUNCATE TABLE gap_transport_record;
TRUNCATE TABLE gap_storage_check;
TRUNCATE TABLE gap_storage_out_record;
TRUNCATE TABLE gap_storage_in_record;
TRUNCATE TABLE gap_storage_area;

-- Module 5: 采收加工管理
TRUNCATE TABLE gap_package_record;
TRUNCATE TABLE gap_drying_record;
TRUNCATE TABLE gap_process_detail;
TRUNCATE TABLE gap_process_record;
TRUNCATE TABLE gap_harvest_record;
TRUNCATE TABLE gap_harvest_plan;

-- Module 4: 农事活动管理
TRUNCATE TABLE gap_fertilization_detail;
TRUNCATE TABLE gap_fertilization_record;
TRUNCATE TABLE gap_irrigation_record;
TRUNCATE TABLE gap_pest_control;
TRUNCATE TABLE gap_farming_detail;
TRUNCATE TABLE gap_farming_record;
TRUNCATE TABLE gap_planting_plan;

-- Module 3: 投入品管理
TRUNCATE TABLE gap_waste_disposal;
TRUNCATE TABLE gap_input_use_record;
TRUNCATE TABLE gap_input_inventory;
TRUNCATE TABLE gap_input_supplier;
TRUNCATE TABLE gap_input_product;
TRUNCATE TABLE gap_input_category;

-- Module 2: 品种种子管理
TRUNCATE TABLE gap_seed_treatment;
TRUNCATE TABLE gap_origin_identify;
TRUNCATE TABLE gap_seed_batch;
TRUNCATE TABLE gap_variety;

-- Module 1: 基地档案管理
TRUNCATE TABLE gap_plot_planting;
TRUNCATE TABLE gap_plot;
TRUNCATE TABLE gap_base_facility;
TRUNCATE TABLE gap_base_weather;
TRUNCATE TABLE gap_base_water;
TRUNCATE TABLE gap_base_soil;
TRUNCATE TABLE gap_base_environment;
TRUNCATE TABLE gap_base_info;

SET FOREIGN_KEY_CHECKS = 1;
